import { Injectable } from '@angular/core';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  facilityList: Facility[] = [
    {
      id: 1,
      name: 'Villa 001',
      area: 100,
      cost: 5500,
      maxPeople: 12,
      rentType: 'Day',
      standardRoom: 'Vip',
      descriptionOfOtherConvenience: 'None',
      poolArea: 10,
    },

    {
      id: 2,
      name: 'House 001',
      area: 200,
      cost: 7000,
      maxPeople: 5,
      rentType: 'Month',
      standardRoom: 'Normal',
      descriptionOfOtherConvenience: 'None',
    },

    {
      id: 3,
      name: 'Room 001',
      area: 50,
      cost: 1000,
      maxPeople: 2,
      rentType: 'Hour',
      standardRoom: 'Vip',
      descriptionOfOtherConvenience: 'None',
    }

  ];

  constructor() { }

  getAll() {
    return this.facilityList;
  }

}
