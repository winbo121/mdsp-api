package egovframework.com.cmm.validation;

import javax.validation.groups.Default;


/**
 * 
 * Request의 데이터를 DTO메서 Validation 체크 시 업무별로 분리하기 위한 ValidGroups interface<br>
 * 필요에 따라서 interface를 추가해서 사용하면 된다.
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
public final class ValidGroups {

    private ValidGroups() {}

    public interface Insert extends Default {};
    public interface Update extends Default {};
    public interface Delete extends Default {};
    
}
