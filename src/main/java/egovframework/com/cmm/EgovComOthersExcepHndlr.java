package egovframework.com.cmm;

import org.egovframe.rte.fdl.cmmn.exception.handler.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @Class Name : EgovComOthersExcepHndlr.java
 * @Description : 공통서비스의 exception 처리 클래스
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2009. 3. 13.     이삼섭
 *
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 3. 13.
 * @version
 * @see
 *
 */
@Slf4j
public class EgovComOthersExcepHndlr implements ExceptionHandler {

    public void occur(Exception exception, String packageName) {
    	log.debug(" EgovServiceExceptionHandler run...............");
    	log.error(packageName, exception);
    }
}
