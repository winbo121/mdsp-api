package egovframework.com.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Object(Source Object)에 있는 필드 값들을 자동으로 원하는 Object(Destination Object)에
 * Mapping 시켜주는 model Mapper 설정
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
public class ModelMapperConfig {

	@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
	
}
