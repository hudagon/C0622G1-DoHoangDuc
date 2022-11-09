package com.casestudy.controller.contract;

import com.casestudy.dto.ContractDetailDto;
import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.facility.Facility;
import com.casestudy.service.attach_facility_service.IAttachFacilityService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.contract_detail.IContractDetailService;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contract/v1")
public class ContractRestController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/calculateMoney/{contractId}")
    public ResponseEntity<String> calculateMoney(@PathVariable String contractId) {
        return new ResponseEntity<>(contractService.getTotalMoney(Integer.valueOf(contractId)), HttpStatus.OK);
    }

    @GetMapping("/attachFacilityList/{contractId}")
    public ResponseEntity<List<ContractDetailDto>> getAttachFacilityList(@PathVariable String contractId) {

        List<ContractDetail> contractDetailList = contractDetailService.
                findByContractIdForAttachFacility(Integer.valueOf(contractId));

        List<ContractDetailDto> contractDetailDtoList = new ArrayList<>();

        for (ContractDetail x : contractDetailList) {
            ContractDetailDto contractDetailDto = new ContractDetailDto();

            BeanUtils.copyProperties(x, contractDetailDto);

            contractDetailDto.setAttachFacilityName(x.getAttachFacility().getName());
            contractDetailDto.setAttachFacilityUnit(x.getAttachFacility().getUnit());

            contractDetailDtoList.add(contractDetailDto);
        }

        return new ResponseEntity<>(contractDetailDtoList, HttpStatus.OK);
    }

    @GetMapping("/getAttachFacility/{attachFacilityId}")
    public ResponseEntity<AttachFacility> getAttachFacility(@PathVariable String attachFacilityId) {
        Optional<AttachFacility> attachFacility = attachFacilityService.findById(Integer.valueOf((attachFacilityId)));
        return new ResponseEntity<>(attachFacility.get(), HttpStatus.OK);
    }

    @GetMapping("/getFacility/{facilityId}")
    public ResponseEntity<Facility> getFacility(@PathVariable String facilityId) {
        Optional<Facility> facility = facilityService.findById(Integer.valueOf(facilityId));
        return new ResponseEntity<>(facility.get(), HttpStatus.OK);
    }
}
