package egovframework.mdsp.api.sample.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import egovframework.com.cmm.annotation.validation.ValidEmail;
import egovframework.com.cmm.annotation.validation.ValidPassword;
import egovframework.com.cmm.validation.ValidGroups;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Spring Validation Sample DTO 클래스
 * 
 * @유효성타입(message="시스템에 출력될 메세지", groups = {Controller에서 선언되는 Validation Group으로 다중으로 적용 가능})<br>
 * message는 Validation 자체 message를 사용 할 경우 선언 하지 않아도 되지만 좀 더 직관적인 message가 필요 시 선언해서 사용<br><br>
 * 
 * 예시)<br>
 * public ModelAndView regMemberJoin(@Validated(ValidGroups.Insert.class) MemberDto memberDto<br>
 * 컨트롤러에서 Validation 검증 시 Validated에 선언된 ValidGroups Class가 Dto에 groups에 적용된 값에 대해서만 Validation 체크를 한다.<br>
 * 컨트롤러에서 Validation 검증 시 Valid로 선언하면 Dto에 groups 속성이 없는 값에 대해서만 Validation 체크를 한다.<br><br>
 * 
 * 유의사항 : Validation Type이 null 값이 유효한 경우라도 숫자타입 자료구조는 Type에러 발생<br>
 * 		   Validation Type이 null 값이 유효한 경우 @NotBlank 같이 선언해서 null과 공백에 대한 유효성 체크 필요<br>
 *         BigDecimal Type이 허용된 Validation인 경우 데이터 타입을 BigDecimal로 선언하고 Request로 전달 받을 경우에는 <br>
 *         BigDecimal Type 에러가 발생하기 때문에 BigDecimal Type 사용시에는 methods직접 호출 시 사용하고 Request로 받아서 검증 시에는 BigDecimal 사용 불가<br>
 * 
 * @author 임명호
 * @version 1.0
 * @since 2024.07.24
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.24     임명호       최초 생성
 * </pre>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ValidationSampleDto {

	/*
	 * @유효성타입(message="시스템에 출력될 메세지", groups = {Controller에서 선언되는 Validation Group으로 다중으로 적용 가능})
	 * message는 Validation 자체 message를 사용 할 경우 선언 하지 않아도 되지만 좀 더 직관적인 message가 필요 시 선언해서 사용
	 * 유의사항 : Validation Type이 null 값이 유효한 경우라도 숫자타입 자료구조는 Type에러 발생
	 * 		   Validation Type이 null 값이 유효한 경우 @NotBlank 같이 선언해서 null과 공백에 대한 유효성 체크 필요
	 *         BigDecimal Type이 허용된 Validation인 경우 데이터 타입을 BigDecimal로 선언하고 Request로 전달 받을 경우에는 
	 *         BigDecimal Type 에러가 발생하기 때문에 BigDecimal Type 사용시에는 methods직접 호출 시 사용하고 Request로 받아서 검증 시에는 BigDecimal 사용 불가
	 * 
	 * 예시)
	 * public ModelAndView regMemberJoin(@Validated(ValidGroups.Insert.class) MemberDto memberDto
	 * 컨트롤러에서 Validation 검증 시 Validated에 선언된 ValidGroups Class가 Dto에 groups에 적용된 값에 대해서만 Validation 체크를 한다.
	 */
	

	/*
	 * false 값인지 검증
	 * null 유효
	 * 지원타입 : boolean, Boolean
	 */
	@AssertFalse(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class, ValidGroups.Delete.class})
	private boolean assertFalse;
	
	/*
	 * true 값인지 검증
	 * null 유효
	 * 지원타입 : boolean, Boolean
	 */
	@AssertTrue(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class, ValidGroups.Update.class})
	private boolean assertTrue;
	
	/*
	 * value 값보다 작은지 검증
	 * inclusive = true : value보다 작거나 같거나		false : value보다 작은지 (default는 true라서 value보다 작은 값인지만 검증하는 것이면 선언 안해도 된다.)
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@DecimalMax(value = "10", inclusive = true, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class, ValidGroups.Delete.class})
	private BigInteger decimalMax;
	
	/*
	 * value 값보다 큰지 검증
	 * inclusive = true : value보다 크거나 같거나		false : value보다 큰지 (default는 true라서 value보다 큰 값인지만 검증하는 것이면 선언 안해도 된다.)
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@DecimalMin(value = "10", inclusive = true, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class, ValidGroups.Delete.class})
	private BigInteger decimalMin;
	
	/*
	 * 허용 가능한 자리수를 지정한 크기를 넘지 않는지 검증
	 * integer = 허용 가능한 정수 자리수, fraction = 허용 가능한 실수 자리수
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@Digits(integer = 5, fraction = 5, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class, ValidGroups.Delete.class})
	private BigInteger digits;
	
	/*
	 * min, max 사이의 값인지 검증
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@Range(min = 10, max = 20, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int rang;
	
	/*
	 * value 값보다 같거나 작은지 검증
	 * value = 허용 가능한 값
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@Max(value = 5, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int max;
	
	/*
	 * value 값보다 같거나 큰지 검증
	 * value = 허용 가능한 값
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, CharSequence를 상속한 자료형 객체, byte, short, int, long 및 관련 래퍼 타입
	 */
	@Min(value = 5, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int min;
	
	/*
	 * 값이 양수인지 검증 (0 값도 잘못된 값)
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, byte, short, int, long, float, double 및 관련 래퍼 타입
	 */
	@Positive(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int positive;
	
	/*
	 * 값이 양수 또는 0인지 검증
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, byte, short, int, long, float, double 및 관련 래퍼 타입
	 */
	@PositiveOrZero(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int positiveOrZero;
	
	/*
	 * 값이 음수인지 검증 (0 값도 잘못된 값)
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, byte, short, int, long, float, double 및 관련 래퍼 타입
	 */
	@Negative(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int negative;
	
	/*
	 * 값이 음수 또는 0인지 검증
	 * null 유효
	 * 지원타입 : BigDecimal, BigInteger, byte, short, int, long, float, double 및 관련 래퍼 타입
	 */
	@NegativeOrZero(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private int negativeOrZero;
	
	/*
	 * 지정된 값의 길이보다 크거나 같은지 작거나 같은지 검증
	 * min = 최소 크기, max = 최대 크기 (min, max 둘 중 하나만 선언해서 사용 가능)
	 * null 유효
	 * 지원타입 : CharSequence를 상속한 객체, Collection, map, array 속성
	 */
	@Size(min = 5, max = 10, message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String size;
	
	/*
	 * 지정된 값의 길이보다 크거나 같은지 작거나 같은지 검증
	 * min = 최소 크기, max = 최대 크기 (min, max 둘 중 하나만 선언해서 사용 가능)
	 * null 유효
	 * 지원타입 : CharSequence를 상속한 객체, Collection, map, array 속성
	 */
	@Size(min = 5, max = 10, groups = {ValidGroups.Insert.class})
	private String noMsgSize;
	
	/*
	 * null 이외의 값은 들어오는지 검증 (null 이외의 값은 들어올수 없음)
	 * Parameter에 form데이터 객체만 들어와도 에러 출력
	 * 지원타입 : 모든 타입 허용
	 */
	@Null(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String isNull;
	
	/*
	 * null 값이 들어오는지 검증 (null 값은 들어올수 없음)
	 * 공백을 허용해서 Parameter에 form데이터 객체에 값이 없이 들어오면 Pass한다.
	 * 지원타입 : 모든 타입 허용
	 */
	@NotNull(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String notNull;
	
	/*
	 * null 값이 들어오는지 검증 (null 값은 들어올수 없음)
	 * 공백을 허용해서 Parameter에 form데이터 객체에 값이 없이 들어오면 Pass한다.
	 * 지원타입 : 모든 타입 허용
	 * 에러 메세지 Default 사용
	 */
	@NotNull(groups = {ValidGroups.Insert.class})
	private String noMsgNotNull;
	
	/*
	 * null 값이 들어오는지 검증 (null 값은 들어올수 없음)
	 * Parameter에 form데이터 객체에 값이 없이 들어와도 Pass한다. (공백 허용)
	 * 지원타입 : 모든 타입 허용
	 * 에러 메세지 Default 사용, groups 미사용
	 */
	@NotNull
	private String noMsgGroupsNotNull;
	
	/*
	 * null이 아니고 최소한 한 개 이상의 공백이 아닌 문자인지 검증
	 * Collection의 경우 null이 아니고 크기가 0이 아닌지 검증
	 * 지원타입 : CharSequence를 상속한 객체
	 */
	@NotBlank(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String notBlank;
	
	/*
	 * 문자열, 배열의 경우 null이 아니고 길이가 0아 아닌지 검증 (공백문자 허용)
	 * Collection의 경우 null이 아니고 크기가 0이 아닌지 검증
	 * 지원타입 : CharSequence를 상속한 객체, Collection, map, array 속성
	 */
	@NotEmpty(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String notEmpty;
	
	/*
	 * String regxp 정규표현식으로 값 검증
	 * null 유효
	 * 지원타입 : CharSequence를 상속한 객체
	 * 샘플 regexp : 숫자만
	 */
	@Pattern(regexp = "^[0-9]*$", message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String pattern;
	
	/*
	 * 값의 시간이 시스템 기준 과거 시간인지 검증
	 * null 유효
	 * 지원타입 : 시간 관련 타입
	 * 맵핑 데이타 포멧은 Dto에 선언한 시간 관련 타입의 default 포멧으로 전달
	 * Date 선언 맵핑 데이타 포멧 예) yyyy/MM/dd(시간은 자동으로 00:00:00으로 셋팅되서 비교), yyyy/MM/dd HH:mm:ss
	 */
	@Past(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private Date past;
	
	/*
	 * 값의 시간이 시스템 기준 과거 또는 현재 시간인지 검증
	 * null 유효
	 * 지원타입 : 시간 관련 타입
	 * 맵핑 데이타 포멧은 Dto에 선언한 시간 관련 타입의 default 포멧으로 전달 
	 * Date 선언 맵핑 데이타 포멧 예) yyyy/MM/dd(시간은 자동으로 00:00:00으로 셋팅되서 비교), yyyy/MM/dd HH:mm:ss
	 */
	@PastOrPresent(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private Date pastOrPresent;
	
	/*
	 * 값의 시간이 시스템 기준 미래 시간인지 검증
	 * null 유효
	 * 지원타입 : 시간 관련 타입
	 * 맵핑 데이타 포멧은 Dto에 선언한 시간 관련 타입의 default 포멧으로 전달 
	 * Date 선언 맵핑 데이타 포멧 예) yyyy/MM/dd(시간은 자동으로 00:00:00으로 셋팅되서 비교), yyyy/MM/dd HH:mm:ss
	 */
	@Future(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private Date future;
	
	/*
	 * 값의 시간이 시스템 기준 미래 또는 현재 시간인지 검증
	 * null 유효
	 * 지원타입 : 시간 관련 타입
	 * 맵핑 데이타 포멧은 Dto에 선언한 시간 관련 타입의 default 포멧으로 전달 
	 * Date 선언 맵핑 데이타 포멧 예) yyyy/MM/dd(시간은 자동으로 00:00:00으로 셋팅되서 비교), yyyy/MM/dd HH:mm:ss
	 */
	@FutureOrPresent(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private Date futureOrPresent;
	
	/*
	 * 값이 Email 형식인지 검증
	 * 검증 정규식 : xxx@xxx
	 * 검증 형식이 최상의 도메인은 검증을 하지 않는다 (예 - .com 까지는 검증하지 않고 @뒤에 문자열이 있는지만 검증)
	 * null 유효
	 * 지원타입 : CharSequence를 상속한 객체
	 */
	@Email(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String email;
	
	/*
	 * 값이 Email 형식인지 CustomValidator로 검증
	 * 내장된 Email Validator는 @뒤에 문자열이 있는지만 검증을 해서 최상의 도메인(예 - .com)까지 검증 될 수 있게 Custom한 Email Validator
	 * 검증 정규식 : xxx@xxx.xxx
	 * 지원타입 : CharSequence를 상속한 객체
	 */
	@ValidEmail(message = "시스템에 출력될 메세지 작성", groups = {ValidGroups.Insert.class})
	private String validEmail;
	
	/*
	 * 영문대소문자+특수문자+숫자 조합 8자 이상 50자 이하 CustomValidator로 검증
	 * KISA 패스워드 가이드라인 정책에 맞는 검증 방식을 Custom한 Validator
	 * 지원타입 : CharSequence를 상속한 객체
	 */
	@ValidPassword(message = "비밀번호 규칙에 맞지 않습니다.", groups = {ValidGroups.Insert.class})
    private String 	password;
}
