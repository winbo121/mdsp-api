package egovframework.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * Spring WebMvcConfigurer 추가 설정
 *
 * @author 임명호
 * @version 1.0
 * @since 2024.07.08
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.08    임명호        최초 생성
 * </pre>
 */ 

@Configuration
public class EgovConfigWeb implements WebMvcConfigurer {
	
	@Autowired
	Environment env;

	//웹 브라우저에서 다른 출처(origin)의 리소스를 요청할 수 있는 설정
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		
        registry.addMapping("/**")
                .allowedOrigins("*")    //외부에서 들어오는 모둔 url 을 허용
                .allowedMethods(
                		HttpMethod.GET.name()
                		,HttpMethod.HEAD.name()
                		,HttpMethod.POST.name()
                		,HttpMethod.PUT.name()
                		,HttpMethod.DELETE.name()
                );
        
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}
	
}
