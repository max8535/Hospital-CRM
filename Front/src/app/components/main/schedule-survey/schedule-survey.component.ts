import {Component, EventEmitter, Input, Output} from '@angular/core';
import {DatePipe} from '@angular/common';
import {ScheduleSurveyModel, ScheduleSurveyStatus, scheduleSurveyTextMap} from "../../../models/schedule-survey.model";
import {ScheduleSurveyService} from "../../../services/schedule-survey.service";
import {AppService} from "../../../services/app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-schedule-survey',
  templateUrl: './schedule-survey.component.html',
  styleUrls: ['./schedule-survey.component.scss'],
  providers: [DatePipe],
})
export class ScheduleSurveyComponent {
  @Input() schedule!: ScheduleSurveyModel;
  @Input() hideButtons: boolean = false;
  @Output() updateSchedule = new EventEmitter<boolean>();

  constructor(
    private scheduleSurveyService: ScheduleSurveyService,
    private appService: AppService,
    private router: Router,
  ) {
  }

  get statusText(): string {
    return scheduleSurveyTextMap[this.schedule.status as any];
  }

  get canCancel(): boolean {
    return this.schedule.status === ScheduleSurveyStatus.PLANNED;
  }

  get canApprove(): boolean {
    return !this.appService.isPatient && this.schedule.status === ScheduleSurveyStatus.PLANNED;
  }

  cancel() {
    this.schedule.status = ScheduleSurveyStatus.REJECTED;
    return this.scheduleSurveyService.updateScheduleSurvey(this.schedule).subscribe();
  }

  approve() {
    this.router.navigate(['/survey-result/create'], {queryParams: {scheduleId: this.schedule.id}})
  }
}
