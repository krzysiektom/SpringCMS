package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @ModelAttribute("allCategories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/")
    public String showAllCategories(){
        return "allCategories";
    }

    @GetMapping("/addCategory")
    public String showForm(Model model) {
        Category category = new Category();
        model.addAttribute(category);
        return "formCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "formCategory";
        }
        categoryRepository.save(category);
        return "redirect:/categories/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Category category = categoryRepository.getById(id);
        model.addAttribute("category", category);
        return "formCategory";
    }

    @PostMapping("/edit/{id}")
    public String modifyCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "formCategory";
        }
        categoryRepository.save(category);
        return "redirect:/categories/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepository.delete(id);
        return "redirect:/categories/";
    }
}
