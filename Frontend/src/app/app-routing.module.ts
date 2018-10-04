import { AuthenticateComponent } from './authenticate/authenticate.component';
import { FrontDashboardComponent } from './front-dashboard/front-dashboard.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieScreeningComponent } from './movie-screening/movie-screening.component';
import { ProducerDashboardComponent } from './producer-dashboard/producer-dashboard.component';

const routes: Routes = [
    {path:'',component:FrontDashboardComponent},
    {path:'login', component:AuthenticateComponent},
    {path:'user',component:RegistrationFormComponent},
    {path:'dashboard', component:ProducerDashboardComponent},
    {path:'eventcast', component:MovieScreeningComponent}
 ];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }

  export const routingComponents = [MovieScreeningComponent,ProducerDashboardComponent, RegistrationFormComponent,FrontDashboardComponent,AuthenticateComponent];