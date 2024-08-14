package egovframework.com.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Swagger 사용을 위한 OpenApi Config
 * uri : /swagger-ui/index.html
 *
 * @author 임명호
 * @version 1.0
 * @since 2024.07.25
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.25    임명호	      최초 생성
 * </pre>
 */

@Configuration
public class OpenApiSwaggerConfig {
	
	/**
	 * api-sample 그룹 설정
	 *
	 * @author limmyungho
	 * @since 24.07.25
	 */
	@Bean
    public GroupedOpenApi sampleApiGroup() {
        return GroupedOpenApi.builder()
                .group("api-sample")
                .pathsToMatch("/sample/api/**")
                .build();
    }
	
}
