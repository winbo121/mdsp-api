package egovframework.com.cmm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * RuntimeException Custom
 * RuntimeException를 상속 받아서 처리한다.
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

@AllArgsConstructor
@Getter
public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomRuntimeException(String message) {
        super(message);
        System.out.println("################CustomRuntimeException################");
    }
    
}
