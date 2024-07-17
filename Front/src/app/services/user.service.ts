import {BaseService} from "./http.service";
import {Observable} from "rxjs";
import {UserModel} from "../models/user.model";
import {Injectable} from "@angular/core";
import {DoctorModel} from "../models/doctor.model";
import {PatientModel} from "../models/patient.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private baseService: BaseService) {
  }

  getUserById(userId: number): Observable<UserModel> {
    return this.baseService.get(`/users/${userId}`)
  }

  getDoctorByUserId(userId: number) {
    return this.baseService.get(`/users/${userId}`)
  }

  getPatientByUserId(userId: number): Observable<PatientModel>  {
    return this.baseService.get(`/patients/by-user-id/${userId}`)
  }

  getAllDoctors(): Observable<DoctorModel[]> {
    return this.baseService.get('/doctors')
  }
}
