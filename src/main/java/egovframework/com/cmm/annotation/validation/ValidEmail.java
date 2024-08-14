package egovframework.com.cmm.annotation.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import egovframework.com.cmm.validation.EmailCustomValidator;

/**
 * 
 * email 형식의 Validation 체크 Annotation
 *
 * @author 임명호
 * @version 1.0
 * @since 2024.07.22
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.22     임명호       최초 생성
 * </pre>
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCustomValidator.class)
@Documented
public @interface ValidEmail {
	
	String message() default "email is not allow";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
