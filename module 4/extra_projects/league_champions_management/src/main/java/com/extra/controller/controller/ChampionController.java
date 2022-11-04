package com.extra.controller.controller;

import com.extra.dto.ChampionDtoShow;
import com.extra.model.Champion;
import com.extra.model.ChampionClass;
import com.extra.service.champion.IChampionService;
import com.extra.service.champion_class.IChampionClassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/champion")
public class ChampionController {

    @Autowired
    private IChampionService championService;

    @Autowired
    private IChampionClassService championClassService;

    @GetMapping("/list")
    public String showListChampion(Model model) {

        List<Champion> championList = (List<Champion>) championService.findAll();
        List<ChampionDtoShow> championListDtoShow = new ArrayList<>();


        for (Champion x : championList) {
            ChampionDtoShow championDtoShow = new ChampionDtoShow();
            BeanUtils.copyProperties(x, championDtoShow);
            championDtoShow.setChampionClassName(x.getChampionClass().getName());
            championListDtoShow.add(championDtoShow);
        }

        model.addAttribute("championListDtoShow", championListDtoShow);

        return "/champion/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditChampionForm(@PathVariable Integer id, Model model) {
        Optional<Champion> championToEdit = championService.findById(id);
        List<ChampionClass> championClassList = (List<ChampionClass>) championClassService.findAll();

        if (!championToEdit.isPresent()) {
            return "/champion/error";
        }

        model.addAttribute("championToEdit", championToEdit.get());
        model.addAttribute("championClassList", championClassList);

        return "/champion/edit";
    }

    @PostMapping("/edit")
    public String editChampion(@ModelAttribute Champion championToEdit,
                               RedirectAttributes redirectAttributes) {

        championService.save(championToEdit);
        redirectAttributes.addFlashAttribute("mess", "Edit successfully!");

        return "redirect:/champion/list";
    }



}
