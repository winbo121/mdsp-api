package egovframework.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Sample Entity
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
@ToString
@NoArgsConstructor
public class SampleEntity {
	
	private int id;
	private String name;
	private String description;
	private String lastUpdterId;
	private String lastUpdtDate; 

}
