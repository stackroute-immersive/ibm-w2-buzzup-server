import { Theatre } from './theatre';


export class Searchedmovie{
    public id: string;
    public movieName: string;
    public moviePoster: string;
    public synopsis: string;
    public movieReleasedate: string;
    public movieDuration: string;
    public languages: string;
    public movieGenre: string;
    public format: string;
    public hero: string;
    public heroine: string;
    public director: string;

    public theatres:Theatre[] = new Array();
}