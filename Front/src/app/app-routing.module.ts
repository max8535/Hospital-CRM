import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SignupComponent} from "./components/pages/auth/signup/signup.component";
import {LoginComponent} from "./components/pages/auth/login/login.component";
import {MainComponent} from "./components/pages/main/main.component";
import {SignupDoctorComponent} from "./components/pages/auth/signup-doctor/signup-doctor.component";
import {ScheduleFormComponent} from "./pages/auth/schedule-form/schedule-form.component";
import {SurveyResultFormComponent} from "./pages/auth/survey-result-form/survey-result-form.component";

const routes: Routes = [
  {path: '', component: MainComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'auth/signup', component: SignupComponent},
  {path: 'auth/signup-doctor', component: SignupDoctorComponent},
  {path: 'schedule/create', component: ScheduleFormComponent},
  {path: 'survey-result/create', component: SurveyResultFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
