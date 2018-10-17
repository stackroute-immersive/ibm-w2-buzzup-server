import { Seats } from './seats';

// Screening class
export class MovieSchedule{
   public theatreId: string;
   public theatreName: string;
   public emailId: string;
   public  theatreLocation: string;
   public theatreLicenseNo: string;
   public totalnumberOfSeats: string;
   public seatLayout:Seats;
   public typesOfSeats: Array<string>;
   public numberOfSeats: Array<string>;
   public id:string;
   public movieName: string;
   public moviePoster: string;
   public actors: string;
   public actress: string;
   public directors: string;
   public movieGenres: string;
   public synopsis: string;
   public format: string;
   public languages: string;
   public movieDuration: string;
   public movieReleaseDate: string;
   public showNumbers: number;
   public showTimings: string;
   public theatreCity : string;
   public weekendsPrice: Array<string>;
   public weekdaysPrice: Array<string>;
   

}