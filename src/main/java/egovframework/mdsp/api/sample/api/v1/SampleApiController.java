package egovframework.mdsp.api.sample.api.v1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.dto.ResultResponseDto;
import egovframework.com.entity.TestEntity;
import egovframework.mdsp.api.sample.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * Rest API Sample 컨트롤러 클래스
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
 *  2024.07.08    임명호	      최초 생성
 * </pre>
 */

@Tag(name = "Sample API", description = "샘픔 API 입니다.")
@RestController
@RequestMapping("/sample/api/v1")
@RequiredArgsConstructor
@Log4j2
public class SampleApiController {
	
	private final SampleService sampleService;
	
	/**
	 * Rest API 샘플
	 *
	 * @author limmyungho
	 * @since 24.07.10
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ModelAndView 샘플 목록 페이지 
	 * @throws Exception
	 */
	@ApiResponse(responseCode = "200", description = "restapi-sample 1 조회 성공",
            content = @Content(mediaType = "application/json"))
	@Operation(summary = "Rest API 샘플 1", description = "Rest API 샘플 1 상세 설명")
	@GetMapping(value = {"/restapi-sample1"})
	public ResponseEntity<ResultResponseDto<String>> restApiSample1(HttpServletRequest req ,HttpServletResponse rep) throws Exception {
		
		return ResultResponseDto.ok();
		
	}
	
	/**
	 * Rest API 샘플
	 *
	 * @author limmyungho
	 * @since 24.07.10
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ModelAndView 샘플 목록 페이지 
	 * @throws Exception
	 */
	@ApiResponses(value = {
			 	@ApiResponse(responseCode = "200", description = "restapi-sample 2 조회 성공",
			            content = @Content(mediaType = "application/json")),
			 	@ApiResponse(responseCode = "500", description = "restapi-sample 2 조회 에러",
	            content = @Content(mediaType = "application/json"))
			    })
	@Operation(summary = "Rest API 샘플 2", description = "Rest API 샘플 2 상세 설명")
	@GetMapping(value = {"/restapi-sample2"})
	public ResponseEntity<ResultResponseDto<String>> restApiSample2(HttpServletRequest req ,HttpServletResponse rep) throws Exception {
		
		return ResultResponseDto.ok();
		
	}
	
	/**
	 * Rest API 샘플
	 *
	 * @author limmyungho
	 * @since 24.07.10
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ModelAndView 샘플 목록 페이지 
	 * @throws Exception
	 */
	@ApiResponses(value = {
			 	@ApiResponse(responseCode = "200", description = "restapi-error-sample  조회 성공",
			            content = @Content(mediaType = "application/json")),
			 	@ApiResponse(responseCode = "500", description = "restapi-error-sample  조회 에러",
	            content = @Content(mediaType = "application/json"))
			    })
	@Operation(summary = "Rest API 에러 샘플 ", description = "Rest API 에러 샘플 상세 설명")
	@GetMapping(value = {"/restapi-error-sample"})
	public ResponseEntity<ResultResponseDto<String>> restApiErrorSample1(HttpServletRequest req ,HttpServletResponse rep) throws Exception {
		
		return ResultResponseDto.error();
		
	}
	
	/**
	 * json return-sample
	 *
	 * @author limmyungho
	 * @since 24.07.10
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ResponseEntity<ResultResponseDto<TestEntity>> 샘플 Entity 객체
	 * @throws Exception
	 */
	@GetMapping(value = {"/json-return-sample/{id}"})
	public ResponseEntity<ResultResponseDto<TestEntity>> jsonReturnSample(@PathVariable int id, HttpServletRequest req ,HttpServletResponse rep) throws Exception {
		
		TestEntity testEntity = sampleService.selectTestData(1);
		
		return ResultResponseDto.ok(testEntity, "재정의 메세지");
		//return ResultResponseDto.ok(testEntity, MessageUtil.getMessage("sample.test2.msgr", "aaaaa","bbbbbb"));
	}
	
	/**
	 * Json Return Sample List
	 *
	 * @author limmyungho
	 * @since 24.07.10
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ResponseEntity<ResultResponseDto<List<TestEntity>>> 샘플 Entity List 객체
	 * @throws Exception
	 */
	@GetMapping(value = {"/json-return-sample-list"})
	public ResponseEntity<ResultResponseDto<List<TestEntity>>> jsonReturnSampleList(HttpServletRequest req ,HttpServletResponse rep) throws Exception {
		
		List<TestEntity> testAllList = sampleService.selectTestEntityAll();
		
		return ResultResponseDto.ok(testAllList);
		
	}
	
}
