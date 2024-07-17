import {Component} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {AuthService} from "./services/auth.service";
import {AppService} from "./services/app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  isAuthPage: boolean = false;
  currentUrl: string = '';

  constructor(
    private router: Router,
    private authService: AuthService,
    private appService: AppService) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentUrl = this.router.url;
        this.isAuthPage = event.url.includes('/auth');
      }
    });

    this.authService.getMe().subscribe(
      {
        complete: () => {
          setTimeout(() => this.appService.loading = false, 700)
        },
        error: (error) => {
          if (error.status === 401 && !this.router.url.includes("signup")) {
            this.router.navigate(['/auth/login']).then();
          }
          setTimeout(() => this.appService.loading = false, 700)
        },
      }
    )
  }

  get loading(): boolean {
    return this.appService.loading;
  }
}
