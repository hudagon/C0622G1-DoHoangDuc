import {Customer} from "./customer";
import {Employee} from "./employee";
import {Facility} from "./facility";

export interface Contract {
  id?: number;
  customer?: Customer;
  employee?: Employee;
  facility?: Facility;
  startDate?: string;
  endDate?: string;
  deposit?: number;
}
