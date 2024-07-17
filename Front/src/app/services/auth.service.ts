import {BaseService} from "./http.service";
import {Observable, throwError} from "rxjs";
import {UserModel} from "../models/user.model";
import {Injectable} from "@angular/core";
import {catchError, map} from "rxjs/operators";
import {AuthResponseModel} from "../models/auth/auth-response.model";
import {ILoginParams, ISignupParams} from "../models/auth/auth-params.model";
import {AppService} from "./app.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(
    private baseService: BaseService,
    private appService: AppService
  ) {
  }

  checkToken(response: AuthResponseModel) {
    if (response && response.token) {
      localStorage.setItem('token', response.token);
    }
  }

  getMe(): Observable<UserModel> {
    return this.baseService.get(`/auth/me`).pipe(
      map((response: any) => {
        this.checkToken(response);
        this.appService.user = response.user;
        this.appService.isPatient = this.appService.user?.role === 'PATIENT';
        return response && response.user;
      }),
      catchError((error) => {
        return throwError(() => error);
      })
    );
  }

  login({login, password}: ILoginParams): Observable<AuthResponseModel> {
    return this.baseService.post("/auth/login", {login, password}).pipe(
      map((response: any) => {
        this.checkToken(response);
        this.appService.user = response.user;
        this.appService.isPatient = this.appService.user?.role === 'PATIENT';
        return response && response.user;
      }),
    );
  }

  signUpDoctor(model: ISignupParams) {
    return this.baseService.post("/auth/signup/doctor", model).pipe(
      map((response: any) => {
        return response;
      }),
    )
  }

  signUpPatient(model: ISignupParams) {
    return this.baseService.post("/auth/signup", model).pipe(
      map((response: any) => {
        return response;
      }),
    )
  }

  logout() {
    return this.baseService.get("/auth/logout").pipe(
      map((response:any ) => {
        localStorage.removeItem("token");
        return response;
      })
    )
  }
}
