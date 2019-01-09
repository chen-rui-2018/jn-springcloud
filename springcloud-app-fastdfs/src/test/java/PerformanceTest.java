import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发上传测试
 *
 * @author： fengxh
 * @date： Created on 2018/11/1 15:03
 * @version： v1.0
 * @modified By:
 */
public class PerformanceTest {

    public static String PERFORM_FILE_PATH;

    @Autowired
    protected AppendFileStorageClient storageClient;

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:images");
        PERFORM_FILE_PATH = file.getPath() + File.separator + "gs.jpg";
    }

    @Ignore
    @Test
    public void testPerformance() {
        final AtomicInteger failCount = new AtomicInteger(0);
        final AtomicInteger count = new AtomicInteger(0);
        int totalCount = 1000;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.afterPropertiesSet();
        for (int i = 0; i < totalCount; i++) {
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        byte[] bytes = FileUtils.readFileToByteArray(new File(PERFORM_FILE_PATH));
                        StorePath storePath = storageClient.uploadFile(null, new ByteArrayInputStream(bytes),
                                bytes.length, "jpg");
                    } catch (Exception e) {
                        e.printStackTrace();
                        failCount.incrementAndGet();
                    } finally {
                        count.incrementAndGet();
                    }

                }
            });

        }
        while (count.get() < totalCount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
        executor.destroy();
        System.out.println("success count: " + count.get());
        System.out.println("fail count: " + failCount.get());
    }

}
