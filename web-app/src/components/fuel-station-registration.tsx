import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";
import AppModal from "./app-modal";
import { fuelStationData } from "../dto/user-dto";
import { registerFuelStation } from "../service/register-service";

type TModalContent = {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler: () => void;
};

const FuelStationRegisterForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm<fuelStationData>();
  const password = watch("password");
  const [modalContent, setModalContent] = useState<TModalContent>({
    show: false,
    header: "",
    content: "",
    buttonText: "",
    closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
  });

  const onSubmit = (data: fuelStationData) => {
    console.log(data);

    registerFuelStation(data)
      .then((response) => {
        setModalContent({
          show: true,
          header: "Success",
          content: "Registration success",
          buttonText: "Cancel",
          closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
        });
      })
      .catch((error) => {
        console.error("Error registering fuel station:", error.response?.data || error.message);
      });
  };

  return (
    <React.Fragment>
      <Form className="p-1" onSubmit={handleSubmit(onSubmit)}>
        <h2>Register</h2>

        <section>
          <h5>Owner Details</h5>
          <Form.Group className="my-2" as={Row} controlId="fullName">
            <Form.Label column sm="2">
              Full Name
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter full name"
                {...register("fullName", { required: true })}
                isInvalid={!!errors.fullName}
              />
              <Form.Control.Feedback type="invalid">Full name is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="contactNo">
            <Form.Label column sm="2">
              Contact No.
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter Contact no"
                {...register("contactNo", { required: true })}
                isInvalid={!!errors.contactNo}
              />
              <Form.Control.Feedback type="invalid">Contact no is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="district">
            <Form.Label column sm="2">
              District
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter District"
                {...register("district", { required: true })}
                isInvalid={!!errors.district}
              />
              <Form.Control.Feedback type="invalid">District is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="province">
            <Form.Label column sm="2">
              Province
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter province"
                {...register("province", { required: true })}
                isInvalid={!!errors.province}
              />
              <Form.Control.Feedback type="invalid">Province is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="password">
            <Form.Label column sm="2">
              Password
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="password"
                placeholder="Enter password"
                {...register("password", {
                  required: "Password is required",
                  pattern: {
                    value: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/,
                    message:
                      "Password must contain at least 1 uppercase, 1 lowercase, 1 number, 1 special character, and be 8 characters or more",
                  },
                })}
                isInvalid={!!errors.password}
              />
              <Form.Control.Feedback type="invalid">{errors.password?.message}</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-2" controlId="reTypePassword">
            <Form.Label column sm="2">
              Re-enter Password
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="password"
                placeholder="Re-enter password"
                {...register("reTypePassword", {
                  required: "Please re-enter your password",
                  validate: (value) => value === password || "Passwords do not match",
                })}
                isInvalid={!!errors.reTypePassword}
              />
              <Form.Control.Feedback type="invalid">{errors.reTypePassword?.message}</Form.Control.Feedback>
            </Col>
          </Form.Group>
        </section>

        <section>
          <h5>Fuel Station Details</h5>
          <Form.Group className="my-2" as={Row} controlId="fuelStationName">
            <Form.Label column sm="2">
              Fuel Station Name
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter Fuel Station Name"
                {...register("fuelStationName", { required: true })}
                isInvalid={!!errors.fuelStationName}
              />
              <Form.Control.Feedback type="invalid">FuelStationName is required</Form.Control.Feedback>
            </Col>
          </Form.Group>
        </section>

        <Button variant="primary" type="submit">
          Register
        </Button>
      </Form>

      <AppModal
        show={modalContent.show}
        header={modalContent.header}
        content={modalContent.content}
        buttonText={modalContent.buttonText}
        closeHandler={modalContent.closeHandler}
      />
    </React.Fragment>
  );
};
export default FuelStationRegisterForm;
