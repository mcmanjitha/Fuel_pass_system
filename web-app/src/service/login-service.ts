import axios, { AxiosResponse } from "axios";
import { LoginData } from "../dto/user-dto";

export const login = (formData: LoginData): Promise<AxiosResponse> => {
  return axios.post("api/vehlogin", formData, {
    headers: {
      "Content-Type": "application/json",
    },
  });
};
