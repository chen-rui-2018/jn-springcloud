import com.jn.SpringCloudAppFastDfsApplication;
import com.jn.config.FastDfsUploadClient;
import com.jn.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 测试的JUNIT
 *
 * @author： fengxh
 * @date： Created on 2018/10/31 16:40
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudAppFastDfsApplication.class})
public class FastDfsTest {


    @Autowired
    private FastDfsUploadClient fastDfsClientWrapper;


    @Test
    public void fastDfs() throws Exception {
        MultipartFile multipartFile = null;
        try {
            InputStream inputStream = FileUtil.getResourcesFileInputStream("工厂模式.png");
            multipartFile = new MockMultipartFile("file", "工厂模式.png", "text/plain", IOUtils.toByteArray(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fastDfsClientWrapper.uploadFile(multipartFile);
    }


}
