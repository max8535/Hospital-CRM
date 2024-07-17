import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { MainComponent } from './components/pages/main/main.component';
import { LoginComponent } from './components/pages/auth/login/login.component';
import { SignupComponent } from './components/pages/auth/signup/signup.component';
import { SignupDoctorComponent } from './components/pages/auth/signup-doctor/signup-doctor.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AuthInterceptor} from "./services/auth-interceptor.service";
import { DoctorMainComponent } from './components/main/doctor-main/doctor-main.component';
import { ScheduleSurveyContainerComponent } from './components/main/schedule-survey-container/schedule-survey-container.component';
import { ScheduleSurveyComponent } from './components/main/schedule-survey/schedule-survey.component';
import { ScheduleFormComponent } from './pages/auth/schedule-form/schedule-form.component';
import { SurveyResultFormComponent } from './pages/auth/survey-result-form/survey-result-form.component';
import { SurveyResultContainerComponent } from './components/main/survey-result-container/survey-result-container.component';
import { SurveyResultComponent } from './components/main/survey-result/survey-result.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    LoginComponent,
    SignupComponent,
    SignupDoctorComponent,
    DoctorMainComponent,
    ScheduleSurveyContainerComponent,
    ScheduleSurveyComponent,
    ScheduleFormComponent,
    SurveyResultFormComponent,
    SurveyResultContainerComponent,
    SurveyResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
