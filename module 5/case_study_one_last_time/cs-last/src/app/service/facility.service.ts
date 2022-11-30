import { Injectable } from '@angular/core';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  facilityList: Facility[] = [
    {
      id: 'DV-0001',
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
      id: 'DV-0002',
      name: 'House 001',
      area: 200,
      cost: 7000,
      maxPeople: 5,
      rentType: 'Month',
      standardRoom: 'Normal',
      descriptionOfOtherConvenience: 'None',
    },

    {
      id: 'DV-0003',
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

  getFacilityById(facilityId: string) {
    console.log(facilityId)
    for (let x of this.facilityList) {
      if (x.id === facilityId) {
        return x;
      }
    }
  }

}
