import axios, { AxiosResponse } from "axios";
import { FormData, fuelStationData } from "../dto/user-dto";

const axiosInstance = axios.create({
  baseURL: "http://192.168.8.102:10002/vehicle",
  headers: {
    "Content-Type": "application/json",
  },
});

export const registerVehicle = (formData: FormData): Promise<AxiosResponse> => {
  return axiosInstance.post("/register", formData);
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
