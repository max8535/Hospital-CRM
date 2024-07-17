import {UserModel} from "./user.model";

export class DoctorModel {
  id: number;
  specification: string;
  cabinet: string;
  user: UserModel;

  constructor(id: number, specification: string, cabinet: string, user: UserModel) {
    this.id = id;
    this.specification = specification;
    this.cabinet = cabinet;
    this.user = user;
  }
}
