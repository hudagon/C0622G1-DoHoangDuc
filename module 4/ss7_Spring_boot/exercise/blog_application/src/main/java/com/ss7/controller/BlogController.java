package com.ss7.controller;

import com.ss7.model.Blog;
import com.ss7.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public String showList(Model model) {

        model.addAttribute("blogList", blogService.findAll());

        return "/blog/list";
    }

    @GetMapping("/view-blog/{idView}")
    public String viewBlog(@PathVariable Integer idView, Model model) {
        Optional<Blog> blogView = blogService.findById(idView);

        if (blogView.isPresent()) {
            model.addAttribute("blogView", blogView.get());
            return "/blog/view";
        } else {
            return "/blog/error";
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("blogNew", new Blog());

        return "/blog/formCreate";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog newBlog, RedirectAttributes redirectAttributes) {

        blogService.save(newBlog);

        redirectAttributes.addFlashAttribute("mess","New blog created successfully!");

        return "redirect:/blog/list";
    }

    @GetMapping("/edit-blog/{idEdit}")
    public String showEditForm(Model model,@PathVariable int idEdit) {
        Optional<Blog> blogEdit = blogService.findById(idEdit);

        if (blogEdit.isPresent()) {
            model.addAttribute("blogEdit", blogEdit.get());
            return "/blog/formEdit";
        } else {
            return "/blog/error";
        }
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blogEdit, RedirectAttributes redirectAttributes) {
        blogService.save(blogEdit);

        redirectAttributes.addFlashAttribute("mess","Blog Edited successfully!");

        return "redirect:/blog/list";
    }

    @GetMapping("/delete-blog/{idDelete}")
    public String showDeletePage(@PathVariable int idDelete, Model model) {
        Optional<Blog> blogDelete = blogService.findById(idDelete);
        if (blogDelete.isPresent()) {
            model.addAttribute("blogDelete", blogDelete.get());
            return "/blog/delete";
        } else {
            return "/blog/error";
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute Blog blogDelete, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(blogDelete.getId());

        redirectAttributes.addFlashAttribute("mess","Blog Deleted successfully!");

        return "redirect:/blog/list";
    }

}
