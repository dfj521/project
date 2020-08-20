import com.dfj.entity.Admin;
import com.dfj.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class T {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        AdminService adminService = ac.getBean("adminService", AdminService.class);
        List<Admin> all = adminService.findAll();
        System.out.println(all.get(1).getId());
    }
}
