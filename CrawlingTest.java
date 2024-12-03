import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CrawlingTest {

    private static void print(Object o) {
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mydatacenter.or.kr:3441/myd/mydsvc/sub2.do");

        WebElement hiddenInput = driver.findElement(By.id("total"));
        int totalPages = Integer.parseInt(hiddenInput.getDomAttribute("value"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int page = 1; page <= totalPages; page++) {
            if (page > 1) {
                js.executeScript("goPage(" + page + ");");
            }

            wait.until(ExpectedConditions.textToBe(By.cssSelector("span.current"), "" + page));
            readPage(driver, wait, page);
        }

        driver.quit();
    }

    private static void readPage(WebDriver driver, WebDriverWait wait, int page) {
        print("============ " + page + "페이지 크롤링...");
        List<WebElement> services = driver.findElements(By.cssSelector("ul.service-list > a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement service : services) {
            String href = service.getDomAttribute("href");
            if (href == null || href.isEmpty()) {
                continue;
            }

            js.executeScript(href.replace("javascript:", ""));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-table")));
            wait.until((ExpectedCondition<Boolean>) input -> !driver.findElement(By.id("caseMydataSvcNm")).getText().isEmpty());

            print("-서비스명 : " + driver.findElement(By.id("caseMydataSvcNm")).getText());
            print("-기관명 : " + driver.findElement(By.id("caseOrgNm")).getText());
            print("-App Store : " + driver.findElement(By.id("caseMydataSvcIosUrl")).getDomAttribute("href"));
            print("-Google Play : " + driver.findElement(By.id("caseMydataSvcAndroidUrl")).getDomAttribute("href"));
            print("-서비스 소개 : " + driver.findElement(By.id("caseMydataSvcGuidance")).getText());
            print("---------------------------");

            driver.navigate().back();
        }
    }
}