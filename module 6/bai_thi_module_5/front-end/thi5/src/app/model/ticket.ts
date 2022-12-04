import { CarHost } from './car-host';

export interface Ticket {
  id?: number;
  price?: number;
  startPoint?: string;
  endPoint?: string;
  startDate?: string;
  startTime?: string;
  amount?: number;
  carHost?: CarHost;
}
