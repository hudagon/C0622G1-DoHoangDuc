package com.thithu2.controller;

import com.thithu2.dto.HouseRegistrationDto;
import com.thithu2.model.FamilyMember;
import com.thithu2.model.HouseRegistration;
import com.thithu2.service.family_member.IFamilyMemberService;
import com.thithu2.service.house_registration.IHouseRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/houseRegistration")
public class HouseRegistrationController {

    @Autowired
    private IHouseRegistrationService houseRegistrationService;

    @Autowired
    private IFamilyMemberService familyMemberService;

    @GetMapping("/list")
    public String getListHouseRegistration(Model model,
                                           @PageableDefault(value = 3) Pageable pageable,
                                           @RequestParam(required = false, defaultValue = "") String hostName,
                                           @RequestParam(required = false, defaultValue = "") String numberOfMembers) {

        if (numberOfMembers.equals("")) {
            numberOfMembers = "-1";
        }

        Page<HouseRegistration> houseRegistrationPage = houseRegistrationService.findAll(hostName,
                Integer.valueOf(numberOfMembers), pageable);

        List<HouseRegistrationDto> houseRegistrationDtoList = new ArrayList<>();

        for (HouseRegistration x : houseRegistrationPage) {
            HouseRegistrationDto houseRegistrationDto = new HouseRegistrationDto();

            BeanUtils.copyProperties(x, houseRegistrationDto);

            houseRegistrationDtoList.add(houseRegistrationDto);
        }

        Page<HouseRegistrationDto> houseRegistrationDtoPage = new PageImpl<>(houseRegistrationDtoList,
                pageable, houseRegistrationPage.getTotalElements());

        model.addAttribute("hostName", hostName);

        if (numberOfMembers.equals("-1")) {
            model.addAttribute("numberOfMembers", "");
        } else {
            model.addAttribute("numberOfMembers", numberOfMembers);
        }

        model.addAttribute("houseRegistrationList", houseRegistrationDtoPage);

        return "/house_registration/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {

        Optional<HouseRegistration> houseRegistrationATBE = houseRegistrationService.findById(Integer.valueOf(id));

        HouseRegistrationDto houseRegistrationDtoATBE = new HouseRegistrationDto();

        if (houseRegistrationATBE.isPresent()) {
            BeanUtils.copyProperties(houseRegistrationATBE.get(), houseRegistrationDtoATBE);
            houseRegistrationDtoATBE.setId(houseRegistrationATBE.get().getId());
        }

        model.addAttribute("houseRegistrationDtoATBE", houseRegistrationDtoATBE);

        return "/house_registration/edit";
    }

    @PostMapping("/edit")
    public String editHR (@ModelAttribute HouseRegistrationDto houseRegistrationDtoATBE,
                          RedirectAttributes redirectAttributes) {

        HouseRegistration houseRegistrationATBE = new HouseRegistration();

        BeanUtils.copyProperties(houseRegistrationDtoATBE, houseRegistrationATBE);
        houseRegistrationATBE.setStatus(1);
        houseRegistrationATBE.setId(houseRegistrationDtoATBE.getId());

        houseRegistrationService.save(houseRegistrationATBE);

        redirectAttributes.addFlashAttribute("mess", "House Registration edited successfully!");

        return "redirect:/houseRegistration/list";
    }

    @GetMapping("/familyMemberList/{id}")
    public ResponseEntity<List<FamilyMember>> getFamilyMemberList (@PathVariable String id) {

        List<FamilyMember> familyMemberList = familyMemberService.findAll(Integer.valueOf(id));



        return new ResponseEntity<>(familyMemberList, HttpStatus.OK);
    }

 }















