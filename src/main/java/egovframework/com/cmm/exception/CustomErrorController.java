package egovframework.com.cmm.exception;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import egovframework.com.cmm.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Spring Security 프로세스 실행 중 Exception이 발생 하는 경우 GlobalExceptionHandler에서 catch가 불가능하므로
 * BasicErrorController를 상속 받아서 처리한다.
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

@Controller
@Slf4j
public class CustomErrorController extends BasicErrorController {

    /**
     * 생성자
     * @param errorAttributes
     * @param serverProperties
     * @param errorViewResolvers
     */
    public CustomErrorController(ErrorAttributes errorAttributes,
                                 ServerProperties serverProperties,
                                 List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    /**
     * json Error 일 경우 메시지 출력
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest req) {
    	
        Map<String, Object> body = getErrorAttributes(req, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));
        throw new ValidationException(MessageUtil.getMessage("common.msgtype.error"));
        
    }

}
