import { Component } from '@angular/core';
import {ScheduleSurveyModel} from "../../../models/schedule-survey.model";
import {ScheduleSurveyService} from "../../../services/schedule-survey.service";
import {SurveyResultModel} from "../../../models/survey-result.model";
import {SurveyResultService} from "../../../services/survey-result.service";

@Component({
  selector: 'app-survey-result-container',
  templateUrl: './survey-result-container.component.html',
  styleUrls: ['./survey-result-container.component.scss']
})
export class SurveyResultContainerComponent {
  list: SurveyResultModel[] = [];

  constructor(private surveyResultService: SurveyResultService) {
  }

  ngOnInit() {
    this.getSurveyResultAll();
  }

  getSurveyResultAll() {
    this.surveyResultService.getSurveyResultAll().subscribe(list => {
      this.list = list;
    });
  }
}
