package pl.sda.springmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springmvc.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("message", "Welcome on my website!");
        model.addAttribute("formAtricle", new Article());
        return "index";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute Article formArticle, Model model){

        if (checkNotEmpty(formArticle)){
            model.addAttribute("article", formArticle);
            return "success";
        } else {
            return "redirect:error";
        }

    }

    private boolean checkNotEmpty(Article formArticle) {
        return formArticle.getContent() != null && formArticle.getTitle() != null && formArticle.getTags() != null;
    }

}
