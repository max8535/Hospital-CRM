import { Component } from '@angular/core';
import {IDoctorSignupParams} from "../../../../models/auth/auth-params.model";
import {AuthService} from "../../../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup-doctor',
  templateUrl: './signup-doctor.component.html',
  styleUrls: ['../../../../../styles/components/auth.styles.scss']
})
export class SignupDoctorComponent {
  model: IDoctorSignupParams = {
    login: '',
    password: '',
    repeatedPassword: '',
    firstName: '',
    lastName: '',
    cabinet: null,
    specification: ''
  };
  serverError: string | null = null;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  signUp() {
    this.serverError = null;
    this.authService.signUpDoctor(this.model).subscribe({
      complete: () => {
        this.router.navigate(['auth/login']);
      },
      error: (err) => {
        this.serverError = err
      }
    });
  }
}
