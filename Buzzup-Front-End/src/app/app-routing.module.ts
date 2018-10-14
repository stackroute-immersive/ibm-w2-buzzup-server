import { RsvpComponent } from './rsvp/rsvp.component';
import { PaymentComponent } from './payment/payment.component';
import { CityMovieDetailsComponent } from './city-movie-details/city-movie-details.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { FrontDashboardComponent } from './front-dashboard/front-dashboard.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieScreeningComponent } from './movie-screening/movie-screening.component';
import { ProducerDashboardComponent } from './producer-dashboard/producer-dashboard.component';
import { MovieTheaterDetailsComponent } from './movie-theater-details/movie-theater-details.component';
import { SeatLayoutComponent } from './seat-layout/seat-layout.component';
import { UserPageComponent } from 'src/app/user-page/user-page.component';
import { BookSuccessComponent } from './book-success/book-success.component';

const routes: Routes = [
    {path:'',component:HomePageComponent},
    {path:'rsvp',component:RsvpComponent},
    {path:'success',component:BookSuccessComponent},
    {path:'payment', component:PaymentComponent},
    {path:'movies', component:CityMovieDetailsComponent},
    {path: 'theatredetails', component: MovieTheaterDetailsComponent},
    {path:'search', component: MovieDetailsComponent},
    {path:'user-page', component: UserPageComponent},
    {path:'login', component:AuthenticateComponent},
    {path:'user',component:RegistrationFormComponent},
    {path:'dashboard', component:ProducerDashboardComponent},
    {path:'eventcast', component:MovieScreeningComponent},
    {path: 'seatlayout', component:SeatLayoutComponent}

 ];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }

  export const routingComponents = [MovieScreeningComponent,ProducerDashboardComponent, RegistrationFormComponent,HomePageComponent,AuthenticateComponent,SeatLayoutComponent,MovieTheaterDetailsComponent,MovieDetailsComponent,CityMovieDetailsComponent, PaymentComponent,BookSuccessComponent, RsvpComponent, UserPageComponent ];