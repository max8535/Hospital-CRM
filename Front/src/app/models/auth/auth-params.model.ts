export interface ILoginParams {
  login: string;
  password: string;
}

export interface ISignupParams extends ILoginParams {
  firstName: string;
  lastName: string;
  repeatedPassword: string;
}

export interface IDoctorSignupParams extends ISignupParams {
  cabinet: number | null;
  specification: string;
}

export interface IPatientSignupParams extends ISignupParams {
  age: number | null
  healthInsuranceNumber: number | null
}
