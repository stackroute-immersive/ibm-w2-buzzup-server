import { Theater } from './theater';

// Screening class
export class Screening{
   public movieName: string;
   public theater : Theater;
   public city : string;
   public timeSlot: Array<string>;
   public ticketPrice: Array<string>;
   public movieDate: Date = new Date();

}