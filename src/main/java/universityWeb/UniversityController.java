package universityWeb;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UniversityController {
    private final UniversityService service;

    public UniversityController(UniversityService service) {
        this.service = service;
    }
    //requests

    @GetMapping("/")
    public String getHomePage() {
        return "home"; //view name
    }
    @GetMapping("/Register")
    public String getRegister(){
        return "Register"; //view name
    }
//    @GetMapping("/view")
//    public String getview(){
//        return "viewAll"; //view name
//    }

    @PostMapping("/save")
    public String saveUniversity(@ModelAttribute University univ){
        service.insertUniversity(univ);
        return "redirect:/All";
    }

    @GetMapping("/All")
    public String getAll(Model model, @Param("keyword") Long keyword){
        List<University> list = service.getAllUniversity(keyword);
        model.addAttribute("universities" , list);
        model.addAttribute("keyword" , keyword);
        return "viewAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUniversity(@PathVariable Long id){
        service.deleteUniversity(id);
        return "redirect:/All";
    }
    @RequestMapping("/Edit/{id}")
    public String UpdateUniversity(@PathVariable Long id, Model model){
        University univ = service.getUniversityById(id);
        model.addAttribute("university" , univ);
        return "EditUniversity";  //view name
    }
}
