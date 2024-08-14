package egovframework.com.config.database;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.VFS;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * SqlSessionFactoryBean을 정의할 때 setTypeAliasesPackage 메소드를 이용하여 정의를 할 경우
 * alias를 적용한 후 IDE를 통해 실행시키면 문제없이 잘 실행 되지만
 * 배포를 위해 jar로 빌드한 후 실행하면  ClassNotFoundException 이 발생하며 alias된 타입들을 못찾는 문제가로 인해 VFS 커스텀
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

public class CustomMyBatisVfs extends VFS {

  private final ResourcePatternResolver resourceResolver;

  public CustomMyBatisVfs() {
    this.resourceResolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  protected List<String> list(URL url, String path) throws IOException {
    Resource[] resources = resourceResolver.getResources("classpath*:" + path + "/**/*.class");
    List<String> resourcePaths = new ArrayList<String>();
    for (Resource resource : resources) {
      resourcePaths.add(preserveSubpackageName(resource.getURI(), path));
    }
    return resourcePaths;
  }

  private static String preserveSubpackageName(final URI uri, final String rootPath) {
    final String uriStr = uri.toString();
    final int start = uriStr.indexOf(rootPath);
    return uriStr.substring(start);
  }

}
