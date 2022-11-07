package com.casestudy.controller.contract;

import com.casestudy.dto.ContractDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    private String getContractList(
            Model model,
            @RequestParam(required = false) String customerNameSearch,
            @RequestParam(required = false) String facilityNameSearch,
            @PageableDefault(value = 4) Pageable pageable) {


        if (customerNameSearch == null) {
            customerNameSearch = "";
        }

        if (facilityNameSearch == null) {
            facilityNameSearch = "";
        }


        Page<Contract> contractList = contractService.findAll(customerNameSearch, facilityNameSearch, pageable);
        List<ContractDto> contractDtoList = new ArrayList<>();

        for (Contract x : contractList) {
            ContractDto contractDto = new ContractDto();
            BeanUtils.copyProperties(x, contractDto);

            contractDto.setCustomerName(x.getCustomer().getName());
            contractDto.setFacilityName(x.getFacility().getName());
            contractDto.setEmployeeName(x.getEmployee().getName());

            contractDtoList.add(contractDto);
        }

        Page<ContractDto> contractDtoPage = new PageImpl<>(contractDtoList, pageable, contractList.getTotalElements());

        model.addAttribute("facilityNameSearch", facilityNameSearch);
        model.addAttribute("customerNameSearch", customerNameSearch);
        model.addAttribute("contractList", contractDtoPage);

        return "/contract/list";
    }

}
