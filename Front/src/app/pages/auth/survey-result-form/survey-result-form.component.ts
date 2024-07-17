import {Component} from '@angular/core';
import {ScheduleSurveyModel, ScheduleSurveyStatus} from "../../../models/schedule-survey.model";
import {ActivatedRoute} from "@angular/router";
import {ScheduleSurveyService} from "../../../services/schedule-survey.service";
import {SurveyResultService} from "../../../services/survey-result.service";

@Component({
  selector: 'app-survey-result-form',
  templateUrl: './survey-result-form.component.html',
  styleUrls: ['./survey-result-form.component.scss']
})
export class SurveyResultFormComponent {
  model: {
    title: string,
    description: string,
    scheduleSurvey: ScheduleSurveyModel | null
  } = {
    title: '',
    description: '',
    scheduleSurvey: null,
  };

  constructor(private route: ActivatedRoute,
              private scheduleSurveyService: ScheduleSurveyService,
              private surveyResultService: SurveyResultService) {
    this.route.queryParams.subscribe(params => {
      const scheduleId = params['scheduleId'];
      this.getScheduleSurveyById(+scheduleId);
    });
  }

  getScheduleSurveyById(id: number) {
    return this.scheduleSurveyService.getScheduleSurvey(id).subscribe(data => {
      this.model.scheduleSurvey = data;
    });
  }

  approveScheduleSurvey() {
    this.model.scheduleSurvey!.status = ScheduleSurveyStatus.COMPLETED;
    return this.scheduleSurveyService.updateScheduleSurvey(this.model.scheduleSurvey!).subscribe();
  }

  createSurveyResult() {
    this.approveScheduleSurvey();
    this.surveyResultService.createSurveyResult(this.model).subscribe();
  }
}
