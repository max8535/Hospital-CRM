import {DoctorModel} from "./doctor.model";
import {PatientModel} from "./patient.model";

export class ScheduleSurveyModel {
  doctor: DoctorModel;
  patient: PatientModel;
  id: number;
  status: ScheduleSurveyStatus;
  date: Date


  constructor(doctor: DoctorModel, patient: PatientModel, id: number, status: ScheduleSurveyStatus, date: string) {
    this.doctor = doctor;
    this.patient = patient;
    this.id = id;
    this.status = status;
    this.date = new Date(date);
  }
}

export enum ScheduleSurveyStatus {
  PLANNED = "PLANNED",
  COMPLETED = "COMPLETED",
  REJECTED = "REJECTED"
}

export const scheduleSurveyTextMap: Record<string, string> = {
  [ScheduleSurveyStatus.PLANNED]: 'Запланирована',
  [ScheduleSurveyStatus.COMPLETED]: 'Исполнена',
  [ScheduleSurveyStatus.REJECTED]: 'Отменена',
}
