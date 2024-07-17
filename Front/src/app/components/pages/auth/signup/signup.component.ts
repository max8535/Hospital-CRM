import {Component} from '@angular/core';
import {IDoctorSignupParams, IPatientSignupParams} from "../../../../models/auth/auth-params.model";
import {AuthService} from "../../../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['../../../../../styles/components/auth.styles.scss']
})
export class SignupComponent {
  model: IPatientSignupParams = {
    login: '',
    password: '',
    repeatedPassword: '',
    firstName: '',
    lastName: '',
    age: null,
    healthInsuranceNumber: null
  };
  serverError: string | null = null;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  signUp() {
    this.serverError = null;
    this.authService.signUpPatient(this.model).subscribe({
      complete: () => {
        this.router.navigate(['auth/login']);
      },
      error: (err) => {
        this.serverError = err
      }
    });
  }
}
