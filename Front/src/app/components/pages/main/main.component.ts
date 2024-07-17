import { Component } from '@angular/core';
import {AppService} from "../../../services/app.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {
  constructor(private appService: AppService) {
  }

  get isPatient(): boolean {
    return this.appService.isPatient;
  }
}
