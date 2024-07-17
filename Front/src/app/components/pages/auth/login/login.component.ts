import {Component} from '@angular/core';
import {AuthService} from "../../../../services/auth.service";
import {ILoginParams} from "../../../../models/auth/auth-params.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../../../../../styles/components/auth.styles.scss']
})
export class LoginComponent {
  model: ILoginParams = {login: '', password: ''};
  serverError: string | null = null;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  login() {
    this.serverError = null;
    this.authService.login(this.model).subscribe({
      complete: () => {
        this.router.navigate(['/']);
      },
      error: (err) => {
        this.serverError = err
      }
    });
  }
}
