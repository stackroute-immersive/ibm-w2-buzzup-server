export class Show {
    public showId: string;
    public city: string;
    public movieName: string;
    public theatreName: string;
    public bookingDate: number;
    public releseDate: Date;
    public showDate: Date;
    public slot: string;
    public status: Boolean;
    public bookedSeats: Array<number>;
    public blockedSeats: Array<number>;
    public totalRow: number;
    public totalCol: number;
    public rowValues: Array<number>;
    public colValues: Array<number>;
}