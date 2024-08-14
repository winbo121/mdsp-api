package egovframework.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TestEntity {

    private int id;
    private String name;
    private String description;
    private String lastUpdterId;
    private String lastUpdtDate;
    private String useYn;
    private String chckValue;
    private String selectValue;
}
