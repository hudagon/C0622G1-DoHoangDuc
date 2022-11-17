package com.test.controller;

import com.test.dto.ChampionDto;
import com.test.model.Champion;
import com.test.model.ChampionClass;
import com.test.service.champion.IChampionService;
import com.test.service.champion_class.IChampionClassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/champion")
public class ChampionController {

    @Autowired
    private IChampionService championService;

    @Autowired
    private IChampionClassService championClassService;


    @ModelAttribute("championClassList")
    private List<ChampionClass> getChampionClassList() {
        return (List<ChampionClass>) championClassService.findAll();
    }

    @GetMapping("/list")
    public String showListChampion(Model model,
                                   @PageableDefault(value = 5) Pageable pageable,
                                   @RequestParam(required = false, defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "") String nation,
                                   @RequestParam(required = false, defaultValue = "-1") String championClassId) {

        Page<Champion> championPage = championService.findAll(pageable, name,
                nation, Integer.valueOf(championClassId));

        List<ChampionDto> championDtoList = new ArrayList<>();

        for (Champion x : championPage) {
            ChampionDto championDto = new ChampionDto();

            BeanUtils.copyProperties(x, championDto);

            championDto.setChampionClass(x.getChampionClass().getName());

            championDtoList.add(championDto);
        }

        Page<ChampionDto> championDtoPage = new PageImpl<>(championDtoList, pageable, championPage.getTotalElements());

        model.addAttribute("championList", championDtoPage);
        model.addAttribute("name", name);
        model.addAttribute("nation", nation);
        model.addAttribute("championClassId", championClassId);

        return "/champion/list";
    }

}
