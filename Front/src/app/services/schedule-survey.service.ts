import {BaseService} from "./http.service";
import {Observable} from "rxjs";
import {UserModel} from "../models/user.model";
import {Injectable} from "@angular/core";
import {ScheduleSurveyModel} from "../models/schedule-survey.model";
import {AppService} from "./app.service";
import * as moment from "moment";

@Injectable({
  providedIn: 'root'
})
export class ScheduleSurveyService {
  constructor(private baseService: BaseService, private appService: AppService) {
  }

  getScheduleSurveyAll(): Observable<ScheduleSurveyModel[]> {
    return this.baseService.get(`/schedule-survey`)
  }

  getScheduleSurvey(id: number): Observable<ScheduleSurveyModel> {
    return this.baseService.get(`/schedule-survey/${id}`)
  }

  createScheduleSurvey(model: any) {
    return this.baseService.post('/schedule-survey', {
      patient: model.patient,
      doctor: {
        id: +model.doctor
      },
      date: moment(model.date, 'DD.MM.YYYY HH:mm')
    })
  }

  updateScheduleSurvey(model: ScheduleSurveyModel) {
    return this.baseService.put('/schedule-survey', model)
  }
}
