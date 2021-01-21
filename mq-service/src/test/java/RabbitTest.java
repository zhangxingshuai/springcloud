import com.MqService;
import com.sender.Sender;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MqService.class)
public class RabbitTest {
    @Autowired
    private Sender sender;

    @Test
    public void test(){
        System.out.println("测试");
    }
}
