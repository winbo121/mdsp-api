package egovframework.com.cmm.dto;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import egovframework.com.cmm.constant.MsgTypeCodeConst;
import egovframework.com.cmm.util.MessageUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * API 또는 Front에 Ajax로 리턴 시 json 리턴으로 사용되는 Dto
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

@Getter
@Setter
@Builder
public class ResultResponseDto<T> extends EgovAbstractServiceImpl{
	
    private String timestamp;
    private int status;
    private String messageType;
    private String message;
    private T results;
    
    // 일반
    public static<T> ResponseEntity<ResultResponseDto<T>> ok() {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_INFO, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> ok(final T results) {
        return getResponse(HttpStatus.OK, results, MsgTypeCodeConst.CMM_MSGTYPE_INFO, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> ok(final T results, final String message) {
        return getResponse(HttpStatus.OK, results, MsgTypeCodeConst.CMM_MSGTYPE_INFO, message);
    }


    // 정보
    public static<T> ResponseEntity<ResultResponseDto<T>> info() {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_INFO, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> info(final String message) {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_INFO, message);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> info(final T results, final String message) {
        return getResponse(HttpStatus.OK, results, MsgTypeCodeConst.CMM_MSGTYPE_INFO, message);
    }


    // 경고
    public static<T> ResponseEntity<ResultResponseDto<T>> warn() {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_WARN, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> warn(final String message) {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_WARN, message);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> warn(final T results, final String message) {
        return getResponse(HttpStatus.OK, results, MsgTypeCodeConst.CMM_MSGTYPE_WARN, message);
    }


    // 예외
    public static<T> ResponseEntity<ResultResponseDto<T>> error() {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> error(final String message) {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, message);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> error(final T results, final String message) {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, results, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, message);
    }


    // 질문
    public static<T> ResponseEntity<ResultResponseDto<T>> confirm() {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_CONFIRM, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> confirm(final String message) {
        return getResponse(HttpStatus.OK, null, MsgTypeCodeConst.CMM_MSGTYPE_CONFIRM, message);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> confirm(final T results, final String message) {
        return getResponse(HttpStatus.OK, results, MsgTypeCodeConst.CMM_MSGTYPE_CONFIRM, message);
    }
    
    // 자격증명 없음
    public static<T> ResponseEntity<ResultResponseDto<T>> unAuthorized() {
        return getResponse(HttpStatus.UNAUTHORIZED, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> unAuthorized(final String message) {
        return getResponse(HttpStatus.UNAUTHORIZED, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, message);
    }
    
    // 권한 없음
    public static<T> ResponseEntity<ResultResponseDto<T>> accessDenied() {
        return getResponse(HttpStatus.FORBIDDEN, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, null);
    }
    public static<T> ResponseEntity<ResultResponseDto<T>> accessDenied(final String message) {
        return getResponse(HttpStatus.FORBIDDEN, null, MsgTypeCodeConst.CMM_MSGTYPE_ERROR, message);
    }

    private static<T> ResponseEntity<ResultResponseDto<T>> getResponse(final HttpStatus statusCode, final T results, final String megTypeCode, final String message) {
    	
    	String newMsg = "";

    	if(message == null || message.isEmpty()) {
    		newMsg = MessageUtil.getMessage("common.msgtype."+megTypeCode);
    	}else {
    		newMsg = message;
    	}

    	ResultResponseDto<T> baseResponse = ResultResponseDto.<T>builder()
                .results(results)
                .status(statusCode.value())
                .messageType(megTypeCode)
                .message(newMsg)
                .timestamp(LocalDateTime.now().toString())
                .build();
        ResponseEntity<ResultResponseDto<T>> retVal = new ResponseEntity<ResultResponseDto<T>>(baseResponse, statusCode);
        return retVal;
    }
}
