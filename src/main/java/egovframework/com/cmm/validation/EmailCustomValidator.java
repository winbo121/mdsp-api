package egovframework.com.cmm.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import egovframework.com.cmm.annotation.validation.ValidEmail;

/**
 * 
 * ConstraintValidator Email Custom Validator Class
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
public class EmailCustomValidator implements ConstraintValidator<ValidEmail, String> {

	private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    
    @Override
    public void initialize(ValidEmail constraintAnnotation) {       
    }
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
    	if(email == null) {
    		return false;
    	}
        return (validateEmail(email));
    } 
    
    private boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
}
