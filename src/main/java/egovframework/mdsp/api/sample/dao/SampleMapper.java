package egovframework.mdsp.api.sample.dao;

import java.util.List;

import egovframework.com.entity.SampleEntity;
import egovframework.com.entity.TestEntity;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;


/**
 *
 * Default Samples Mapper 서비스
 *
 * @author 임명호
 * @version 1.0
 * @since 2023.09.05
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2023.09.05    임명호       최초 생성
 * </pre>
 */
@Mapper("sampleMapper")
public interface SampleMapper {

	TestEntity selectTestData(int id) throws Exception;

	List<TestEntity> selectTestEntityAll() throws Exception;

}
