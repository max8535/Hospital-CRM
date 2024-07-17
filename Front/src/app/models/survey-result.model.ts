import {DoctorModel} from "./doctor.model";
import {PatientModel} from "./patient.model";
import {ScheduleSurveyModel} from "./schedule-survey.model";

export class SurveyResultModel {
  id: number;
  scheduleSurvey: ScheduleSurveyModel;
  title: string;
  description: string;


  constructor(id: number, scheduleSurvey: ScheduleSurveyModel, title: string, description: string) {
    this.id = id;
    this.scheduleSurvey = scheduleSurvey;
    this.title = title;
    this.description = description;
  }
}
