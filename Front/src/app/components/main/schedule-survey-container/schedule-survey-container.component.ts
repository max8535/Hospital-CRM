import {Component} from '@angular/core';
import {ScheduleSurveyService} from "../../../services/schedule-survey.service";
import {ScheduleSurveyModel} from "../../../models/schedule-survey.model";

@Component({
  selector: 'app-schedule-survey-container',
  templateUrl: './schedule-survey-container.component.html',
  styleUrls: ['./schedule-survey-container.component.scss']
})
export class ScheduleSurveyContainerComponent {
  list: ScheduleSurveyModel[] = [];

  constructor(private scheduleSurveyService: ScheduleSurveyService) {
  }

  ngOnInit() {
    this.getScheduleSurveyAll();
  }

  getScheduleSurveyAll() {
    this.scheduleSurveyService.getScheduleSurveyAll().subscribe(list => {
      this.list = list;
    });
  }

  onUpdateSchedule() {
    this.getScheduleSurveyAll();
    // todo: updateSchedules event to up;
  }
}
