import {UserModel} from "./user.model";

export class PatientModel {
  id: number;
  age: number;
  user: UserModel;

  constructor(id: number, age: number, user: UserModel) {
    this.id = id;
    this.age = age;
    this.user = user;
  }
}
