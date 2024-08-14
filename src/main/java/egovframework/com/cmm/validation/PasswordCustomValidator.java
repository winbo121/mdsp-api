package egovframework.com.cmm.validation;

import java.text.MessageFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import egovframework.com.cmm.annotation.validation.ValidPassword;

/**
 * 
 * ConstraintValidator Password Custom Validator Class
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
@Component
public class PasswordCustomValidator implements ConstraintValidator<ValidPassword, String> {

    private static final int MIN_SIZE = 8;
    private static final int MAX_SIZE = 50;
    
    //영문대소문자+특수문자+숫자 조합
    private static final String REGX_PASSWORD = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[$@$#!%*?&])[A-Za-z\\d$@$#!%*?&]{" + MIN_SIZE
            + "," + MAX_SIZE + "}$";

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
    	if(password == null) {
    		return false;
    	}
        boolean isValidPassword = password.matches(REGX_PASSWORD);
        if (!isValidPassword) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    MessageFormat.format("{0}자 이상의 {1}자 이하의 숫자, 영문자, 특수문자를 포함한 비밀번호를 입력해주세요", MIN_SIZE, MAX_SIZE))
                    .addConstraintViolation();
        }
        return isValidPassword;
    }

    public boolean isValid(String password) {
        return password.matches(REGX_PASSWORD);
    }
    
}
