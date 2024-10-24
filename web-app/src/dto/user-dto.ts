export interface FormData {
  fullName: string;
  nic: string;
  email: string;
  mobile: string;
  password: string;
  reTypePassword: string;
  licensePlate: string;
  type: string;
  registeredYear: number;
  chassisNo: string;
}

export interface fuelStationData {
  fullName: string;
  contactNo: string;
  district: string;
  province: string;
  password: string;
  reTypePassword: string;
  fuelStationName: string;
}

export interface LoginData {
  licensePlateNo: string;
  password: string;
}
