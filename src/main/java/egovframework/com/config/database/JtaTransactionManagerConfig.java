package egovframework.com.config.database;

import javax.transaction.UserTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 분산 트랜젝션 처리를 위한 JTA 설정
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

@Configuration
@Slf4j
public class JtaTransactionManagerConfig {
	
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
    	
    	log.info("transactionManager() 실행");
    	
    	UserTransaction userTransaction = new UserTransactionImp();
    	userTransaction.setTransactionTimeout(10000);
        
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager(userTransaction, userTransactionManager);
        
        return jtaTransactionManager;
        
    }
    
}