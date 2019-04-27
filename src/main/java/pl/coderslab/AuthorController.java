package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @ModelAttribute("allAuthors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/")
    public String showAllAuthors(){
        return "allAuthors";
    }

    @GetMapping("/addAuthor")
    public String showForm(Model model) {
        Author author = new Author();
        model.addAttribute(author);
        return "formAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "formAuthor";
        }
        authorRepository.save(author);
        return "redirect:/authors/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Author author = authorRepository.getById(id);
        model.addAttribute("author", author);
        return "formAuthor";
    }

    @PostMapping("/edit/{id}")
    public String modifyAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "formAuthor";
        }
        authorRepository.save(author);
        return "redirect:/authors/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.delete(id);
        return "redirect:/authors/";
    }
}
