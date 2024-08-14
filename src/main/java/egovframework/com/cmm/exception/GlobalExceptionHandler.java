package egovframework.com.cmm.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import egovframework.com.cmm.dto.ResultResponseDto;
import egovframework.com.cmm.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 전역으로 예외처리를 담당하는 클래스
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

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
     * RuntimeException Custom
     *
     * @param httpServletRequest
     * @param CustomRuntimeException
     * @return ModelAndView
     * @throws Exception
     */
	@ExceptionHandler({ CustomRuntimeException.class })
    protected ResponseEntity<ResultResponseDto<String>> handleCustomRuntime(HttpServletRequest req, CustomRuntimeException ex) {
		log.error(ex.toString());
		return ResultResponseDto.error();
    }
	
	/**
     * Require Param Validation BindException Handler
     * Dto Bean에서 Validation 설정된 항목에 대해서 데이타 Binding 검증 오류가 나면 bindExceptionHandler에서 Exception 처리
     * 
     * @param HttpServletRequest
     * @param BindException
     * @return ModelAndView
     * @throws Exception
     */
    @ExceptionHandler({BindException.class})
    protected ResponseEntity<ResultResponseDto<String>> bindExceptionHandler(HttpServletRequest req, BindException e) throws Exception{
    	
    	Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        
        log.error(errors.toString());
    	
        return ResultResponseDto.error(MessageUtil.getMessage("exception.bind"));
    }
	
    /**
     * 정의되지 않은 Exception이 일어나면 호출된다.<br>
     * 해당 메소드는 View 호출 타입이 Json, jsp 호출 방식에 따라서 리턴데이터 or 에러페이지를 리턴한다.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param Exception
     * @return ModelAndView
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResultResponseDto<String>> commonError(HttpServletRequest req, Exception e) throws Exception {
    	log.error(e.toString());
        return ResultResponseDto.error();

    }

    
}
