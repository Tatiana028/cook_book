package cook_book.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        return "main-page";
    }

    @GetMapping("/account")
    public String about(Model model) {
        model.addAttribute("title", "About me ");
        return "account";
    }

}


