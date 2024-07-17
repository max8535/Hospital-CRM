import {Component} from '@angular/core';
import {AppService} from "../../services/app.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  constructor(private appService: AppService, private authService: AuthService) {
  }

  get userName(): string | undefined {
    return `${this.appService.user?.lastName} ${this.appService.user?.firstName}`
  }

  get roleName(): string {
    return this.appService.isPatient ? 'Пациент' : 'Доктор';
  }

  logout() {
    this.authService.logout().subscribe({
      complete: () => {
        window.location.replace("/");
      },
    });
  }
}
