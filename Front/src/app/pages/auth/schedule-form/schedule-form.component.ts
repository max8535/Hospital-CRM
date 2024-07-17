import {Component} from '@angular/core';
import {DoctorModel} from "../../../models/doctor.model";
import * as moment from "moment";
import {UserService} from "../../../services/user.service";
import {ScheduleSurveyService} from "../../../services/schedule-survey.service";
import {AppService} from "../../../services/app.service";
import {PatientModel} from "../../../models/patient.model";
import {ActivatedRoute} from "@angular/router";

const date = moment().add(1, 'day').format('DD.MM.YYYY HH:mm');

@Component({
  selector: 'app-schedule-form',
  templateUrl: './schedule-form.component.html',
  styleUrls: ['./schedule-form.component.scss']
})
export class ScheduleFormComponent {
  model: {
    doctor: DoctorModel | null,
    date: string,
    patient: PatientModel | null,
  } = {
    doctor: null,
    patient: null,
    date
  };

  doctors: (DoctorModel | null)[] = [null];

  constructor(private userService: UserService, private scheduleSurveyService: ScheduleSurveyService,
              private appService: AppService,
  ) {

  }

  ngOnInit(): void {
    this.getPatientByUserId();
    this.getAllDoctors();
  }

  getAllDoctors() {
    return this.userService.getAllDoctors().subscribe(doctors => {
      this.doctors = [...this.doctors, ...doctors];
    })
  }

  getPatientByUserId() {
    return this.userService.getPatientByUserId(this.appService.user!.id).subscribe((data) => {
      this.model.patient = data;
    })
  }

  createSchedule() {
    return this.scheduleSurveyService.createScheduleSurvey(this.model).subscribe();
  }
}
