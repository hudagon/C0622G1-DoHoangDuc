package com.casestudy.controller.contract_detail;

import com.casestudy.dto.ContractDetailDto;
import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.attach_facility_service.IAttachFacilityService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.contract_detail.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @PostMapping("/create")
    public String create(@ModelAttribute ContractDetailDto newContractDetailDto,
                         RedirectAttributes redirectAttributes) {

        ContractDetail contractDetailATBC = new ContractDetail();

        BeanUtils.copyProperties(newContractDetailDto, contractDetailATBC);

        Optional<AttachFacility> attachFacilityATBC = attachFacilityService.findById(
                Integer.valueOf(newContractDetailDto.getAttachFacilityName()));

        Optional<Contract> contractATBC = contractService.findById(newContractDetailDto.getContractId());

        contractDetailATBC.setAttachFacility(attachFacilityATBC.get());
        contractDetailATBC.setContract(contractATBC.get());
        contractDetailATBC.setStatus(1);

        contractDetailService.save(contractDetailATBC);

        redirectAttributes.addFlashAttribute("messSuccess", "New contract detail added successfully!");

        return "redirect:/contract/list";
    }
}
