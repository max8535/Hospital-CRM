import {UserModel} from "../user.model";
import {BaseModel} from "../base.model";

export class AuthResponseModel extends BaseModel {
  user: UserModel;
  token: string;

  constructor(user: UserModel, token: string) {
    super();
    this.user = user;
    this.token = token;
  }
}
