package egovframework.mdsp.api.sample.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.exception.CustomRuntimeException;
import egovframework.com.entity.TestEntity;
import egovframework.mdsp.api.sample.dao.SampleMapper;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Default Samples Service 서비스
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


@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class SampleService extends EgovAbstractServiceImpl {
	
    private final SampleMapper sampleMapper;

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	public void errorTest() throws Exception{
		
		List<String> list = new ArrayList<>();

		throw new CustomRuntimeException("sdafasjdlkfjlaskdf");
		
		/*
		try {
			
		} catch (CustomRuntimeException e) {
			// TODO: handle exception
		}
		*/
	}
	
	public List<TestEntity> selectTestEntityAll() throws Exception{
		return sampleMapper.selectTestEntityAll();
	}

	public TestEntity selectTestData(int id) throws Exception {
		return sampleMapper.selectTestData(id);
	}

}