import axios, { AxiosResponse } from "axios";
import { FormData } from "../dto/user-dto";

export const registerVehicle = (formData: FormData, token: string | null): Promise<AxiosResponse> => {
  return axios.post("api/vehiregister", formData, {
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
  });
};

export const validateVehicle = (chassisNo: string, token: string | null): Promise<AxiosResponse> => {
  return axios.get(`api/vehvalidate`, {
    params: {
      chassisNo: chassisNo,
    },
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
  });
};
