package egovframework.com.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * Spring에 주입된 Bean 사용이 필요 하면 Context에서 가져와서 셋팅
 * 멀티,이기종 트랜젝션 처리를 위한 JTA 설정
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
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
