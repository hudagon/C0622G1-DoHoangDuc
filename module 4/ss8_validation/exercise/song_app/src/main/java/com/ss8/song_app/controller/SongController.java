package com.ss8.song_app.controller;

import com.ss8.song_app.model.Song;
import com.ss8.song_app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping("/list")
    public String showListSong(Model model) {
        model.addAttribute("songList", songService.findAll());

        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("songNew", new Song());

        return "/song/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute(value = "songNew") Song songNew,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {


        new Song().validate(songNew, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/song/create";
        }

        songService.save(songNew);

        redirectAttributes.addFlashAttribute("mess", "New song created successfully!");

        return "redirect:/song/list";
    }

    @GetMapping("/edit-song/{idEdit}")
    public String showEditForm(Model model, @PathVariable Integer idEdit) {
        Optional<Song> songEdit = songService.findById(idEdit);

        if (songEdit.isPresent()) {
            model.addAttribute("songEdit", songEdit.get());
            return "/song/formEdit";
        } else {
            return "/song/error";
        }
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Song songEdit, RedirectAttributes redirectAttributes) {
        songService.save(songEdit);

        redirectAttributes.addFlashAttribute("mess", "Song Edited successfully!");

        return "redirect:/song/list";
    }


}
