//Material API
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import {FormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { HttpClientModule } from '@angular/common/http';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatInputModule} from '@angular/material';
import {MatCardModule} from '@angular/material/card';
import { ReactiveFormsModule} from '@angular/forms';
import { MatSnackBarModule } from '@angular/material';
import { MatStepperModule, MatFormFieldModule, MatIconModule, MatRadioModule,  MatProgressBarModule } from '@angular/material';
//import {HttpClient} from '@angular/common/http';
import { enableProdMode } from '@angular/core';
//import {FlexLayoutModule} from '@angular/flex-layout';
import { MAT_LABEL_GLOBAL_OPTIONS } from '@angular/material';
import { TokenStorage } from './core/token.storage';
import { AuthenticateServiceService } from './authenticate-service.service';

import { AuthenticateComponent } from './authenticate/authenticate.component';
import { AppComponent } from './app.component';

// import { MovieScreeningComponent } from './movie-screening/movie-screening.component';
import { MatNativeDateModule } from '@angular/material/core';
// import { ProducerDashboardComponent } from './producer-dashboard/producer-dashboard.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { FrontDashboardComponent } from './front-dashboard/front-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    FrontDashboardComponent,
    AuthenticateComponent
  ],
  imports: [
    BrowserModule,
    MatToolbarModule,
    MatButtonModule,
    MatSelectModule,
    FormsModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    HttpClientModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatInputModule,
    AppRoutingModule,
    MatCardModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    MatStepperModule,
    MatFormFieldModule,
    MatIconModule,
    MatRadioModule,
    MatProgressBarModule
  

  ],
  providers: [{provide: MAT_LABEL_GLOBAL_OPTIONS, useValue: {float: 'never'}}, TokenStorage, AuthenticateServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
