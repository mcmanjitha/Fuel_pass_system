import axios, { AxiosResponse } from "axios";
import { FormData, fuelStationData } from "../dto/user-dto";

export const registerVehicle = (formData: FormData): Promise<AxiosResponse> => {
  return axios.post("api/vehregister", formData, {
    headers: {
      "Content-Type": "application/json",
    },
  });
};

export const validateVehicle = (chassisNo: string): Promise<AxiosResponse> => {
  return axios.get(`api/vehvalidate`, {
    params: {
      chassisNo: chassisNo,
    },
    headers: {
      "Content-Type": "application/json",
    },
  });
};

export const registerFuelStation = (formData: fuelStationData): Promise<AxiosResponse> => {
  return axios.post("api/statregister", formData, {
    headers: {
      "Content-Type": "application/json",
    },
  });
};
