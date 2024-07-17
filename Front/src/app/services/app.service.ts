import {UserModel} from "../models/user.model";
import {Injectable} from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class AppService {
  public loggedIn: boolean = false;
  public user: UserModel | null = null;
  public loading: boolean = true;
  public isPatient: boolean = false;

  constructor() {
  }
}
