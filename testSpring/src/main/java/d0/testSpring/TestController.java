package d0.testSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("/test")
public class TestController {
    private static String dburl = "jdbc:mysql://localhost:3306/jdbc";
    private static String dbUser = "root";
    private static String dbpasswd = "3132";



    @GetMapping("go")
    public String test() {
        return "test";
    }

    @GetMapping("test")
    public String jspTest() {


        System.out.println("asdasd");
            return "test";
    }

}
