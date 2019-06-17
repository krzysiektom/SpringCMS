package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @ModelAttribute("allArticles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("allCategories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/")
    public String showAllArticles() {
        return "allArticles";
    }

    @GetMapping("/addArticle")
    public String showForm(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "formArticle";
    }

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute("article") @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "formArticle";
        }
        System.out.println(article);
        articleRepository.save(article);
        return "redirect:/articles/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Article article = articleRepository.getById(id);
        model.addAttribute("article", article);
        return "formArticle";
    }

    @PostMapping("/edit/{id}")
    public String modifyArticle(@ModelAttribute("article") @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "formArticle";
        }
        articleRepository.save(article);
        return "redirect:/articles/";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleRepository.delete(id);
        return "redirect:/articles/";
    }
}
