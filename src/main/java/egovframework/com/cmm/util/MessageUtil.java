package egovframework.com.cmm.util;

import java.util.Locale;

import org.springframework.stereotype.Component;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.config.ApplicationContextHolder;

/**
 * 
 * EgovMessageSource Static Utils
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
 *  2023.08.30    임명호	      최초 생성
 * </pre>
 */

@Component
public class MessageUtil {

	//Bean으로 주입된 EgovMessageSource를 가져와서 EgovMessageSource 초기화
	private static EgovMessageSource getMessageSource() {
        return (EgovMessageSource) ApplicationContextHolder.getContext().getBean("egovMessageSource", EgovMessageSource.class);
    }
	
    /**
	 * 정의된 메세지 조회
	 * @param code - 메세지 코드
	 * @return String
	 */	
	public static String getMessage(String code) {
		return getMessageSource().getMessage(code);
	}
	
	/**
	 * 정의된 메세지 조회
	 * @param code - 메세지 코드
	 * @param locale - 로케일
	 * @return String
	 */	
	public static String getMessage(String code, Locale locale) {
		return getMessageSource().getMessageArgsLocale(code, null, locale);
	}
	
	/**
	 * 정의된 메세지 조회
	 * @param code - 메세지 코드
	 * @param args - 매개변수
	 * @return String
	 */	
	public static String getMessage(String code, Object... args) {
		return getMessageSource().getMessageArgs(code, args);
	}
	
	/**
	 * 정의된 메세지 조회
	 * @param code - 메세지 코드
	 * @param locale - 로케일
	 * @param args - 매개변수
	 * @return String
	 */	
	public static String getMessage(String code, Locale locale, Object... args) {
		return getMessageSource().getMessageArgsLocale(code, args, locale);
	}
	
}
