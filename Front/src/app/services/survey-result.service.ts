import {BaseService} from "./http.service";
import {Observable} from "rxjs";
import {UserModel} from "../models/user.model";
import {Injectable} from "@angular/core";
import {ScheduleSurveyModel} from "../models/schedule-survey.model";
import {AppService} from "./app.service";
import * as moment from "moment";
import {SurveyResultModel} from "../models/survey-result.model";

@Injectable({
  providedIn: 'root'
})
export class SurveyResultService {
  constructor(private baseService: BaseService, private appService: AppService) {
  }


  createSurveyResult(model: any) {
    return this.baseService.post('/survey-result', model)
  }

  getSurveyResultAll(): Observable<SurveyResultModel[]> {
    return this.baseService.get('/survey-result')
  }
}
