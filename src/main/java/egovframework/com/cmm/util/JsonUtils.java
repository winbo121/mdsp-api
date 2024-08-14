package egovframework.com.cmm.util;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Json 관련 Utils
 *
 * @author 임명호
 * @version 1.0
 * @since 2024.07.17
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.17    임명호	      최초 생성
 * </pre>
 */

@Slf4j
public class JsonUtils {

    protected JsonUtils() {

    }

    /**
     * Request 가 JSON 요청인지 판단
     *
     * @param HttpServletRequest
     * @return true or false
     */
    public static boolean isJsonRequest(HttpServletRequest request){
    	
        if (request == null) {
        	return false;
        }
        
        String accept = request.getHeader("Accept") == null ? "" : request.getHeader("Accept").toLowerCase(Locale.ENGLISH); 
        String contentType = request.getHeader("Content-Type") == null ? "" : request.getHeader("Content-Type").toLowerCase(Locale.ENGLISH);

        if(!StringUtils.isBlank(accept) && accept.matches(".*"+MediaType.APPLICATION_JSON_VALUE+".*")) {
        	return true;
        }else if(!StringUtils.isBlank(contentType) && contentType.matches(".*"+MediaType.APPLICATION_JSON_VALUE+".*")) {
        	return true;
        }
        
        return false;
        
    }

    /**
     * Object 를 JSON 형태로 Response 에 직접 출력할때 사용
     *
     * @param HttpServletRequest
     * @param HttpServletResponse
     * @param object   Json 변환 대상
     * @return 변환된 Json String
     */
    public static String responseWriter(HttpServletRequest request, HttpServletResponse response, Object object) {
        return responseWriter(request, response, object, request.getCharacterEncoding());
    }

    /**
     * Object 를 JSON 형태로 Response 에 직접 출력할때 사용
     *
     * @param HttpServletRequest
     * @param HttpServletResponse
     * @param Object   Json 변환 대상
     * @param String encoding 인코딩
     * @return 변환된 Json String
     */
    public static String responseWriter(HttpServletRequest request, HttpServletResponse response, Object object, String encoding) {
      
        String json = "";
        
		try {
			
			json = new ObjectMapper().writeValueAsString(object);
			
			if (encoding != null) {
	            response.setCharacterEncoding(encoding);
	        }
	        
	        response.getWriter().write(json);
			
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		} catch (IOException e) {
			log.error(e.toString());
		}

        return json;
          
    }
    
}
