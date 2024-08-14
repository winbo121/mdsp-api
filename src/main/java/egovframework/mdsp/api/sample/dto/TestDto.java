package egovframework.mdsp.api.sample.dto;

import egovframework.com.entity.TestEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TestDto extends TestEntity {

    private List<TestEntity> testEntityList;
}
