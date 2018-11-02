import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试的JUNIT
 *
 * @author： fengxh
 * @date： Created on 2018/10/31 16:40
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FastDfsFileSplitTest {




    @Test
    public void fastDfs() throws Exception{
       String filePath = "http://192.168.10.45:2020/group1/M00/00/00/wKgKLVvazSeAGLAxAAMmpEcA_IM580.png";
       String[] fileNames = filePath.split("/",5);
       System.out.println(fileNames[(fileNames.length-1)]) ;



    }


}
