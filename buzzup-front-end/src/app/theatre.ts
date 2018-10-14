// Theater Class
import { Seats } from './seats';

export class Theatre{
public emailId: string;
public theatreId: string;
public theatreLocation: string;
public theatreLicenseNo: string;
public totalnumberOfSeats: string;
public theatreName: string;
public theatreCity: string;
public screenedmovies: Array<string>;
public runningmovies: Array<string>;
public numberOfSeats: Array<string>;
public typesOfSeats: Array<string>;
public seatLayout: Seats;
public weekendsPrice: Array<string>;
public weekdaysPrice: Array<string>;
}