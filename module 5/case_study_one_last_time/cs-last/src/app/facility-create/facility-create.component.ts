import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {FacilityService} from '../service/facility.service';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {

  rfFacility: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private facilityService: FacilityService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getFacilityCreateForm();
  }

  getFacilityCreateForm() {
    this.rfFacility = this.formBuilder.group({
      id: ['', [Validators.required,
        Validators.pattern('^DV-[0-9]{4}$')]],

      name: ['', [Validators.required]],

      area: ['', [Validators.required, Validators.min(0)]],

      cost: ['', [Validators.required, Validators.min(0)]],

      maxPeople: ['', [Validators.required, Validators.min(0)]],

      rentType: ['0', [Validators.pattern('^[^0]$')]],

      standardRoom: ['', [Validators.required]],

      descriptionOfOtherConvenience: ['', [Validators.required]],

      poolArea: ['', [Validators.required, Validators.min(0)]],

      numberOfFloors: ['', [Validators.required, Validators.min(0)]],

      attachFacility: ['', [Validators.required]],
    })
  }

}
