import com.dfj.controller.HelloController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloController helloController = ac.getBean("helloController", HelloController.class);
        helloController.hello();
    }
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext1.xml");
        HelloController helloController = ac.getBean("helloController", HelloController.class);
        helloController.hello();
    }
}
