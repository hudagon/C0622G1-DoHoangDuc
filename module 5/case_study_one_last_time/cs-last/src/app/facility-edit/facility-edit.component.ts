import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FacilityService} from "../service/facility.service";
import {Customer} from "../model/customer";
import {Facility} from "../model/facility";

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {

  rfFacilityEdit: FormGroup;
  facilityId: string;

  constructor(
    private facilityService: FacilityService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.facilityId = params.facilityId;
    });

    this.getEditFacilityForm();
  }

  getEditFacility(facilityId: string): Facility {
    return this.facilityService.getFacilityById(facilityId);
  }

  getEditFacilityForm() {
    const facilityATBE = this.getEditFacility(this.facilityId);
    console.log(facilityATBE)
    this.rfFacilityEdit =  this.formBuilder.group({
      id: [facilityATBE.id, [Validators.required,
        Validators.pattern('^DV-[0-9]{4}$')]],

      name: [facilityATBE.name, [Validators.required]],

      area: [facilityATBE.area, [Validators.required, Validators.min(0)]],

      cost: [facilityATBE.cost, [Validators.required, Validators.min(0)]],

      maxPeople: [facilityATBE.maxPeople, [Validators.required, Validators.min(0)]],

      rentType: [facilityATBE.rentType, [Validators.pattern('^[^0]$')]],

      standardRoom: [facilityATBE.standardRoom, [Validators.required]],

      descriptionOfOtherConvenience: [facilityATBE.descriptionOfOtherConvenience, [Validators.required]],

      poolArea: [facilityATBE.poolArea, [Validators.required, Validators.min(0)]],

      numberOfFloors: [facilityATBE.numberOfFloors, [Validators.required, Validators.min(0)]],

      attachFacility: [facilityATBE.attachFacility, [Validators.required]],
    })
  }

}
