package proyecto.atmosfera.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplatesController {

    @RequestMapping("welcome")
    public String getWelcome(){
        return "Welcome";

    }

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }


}
