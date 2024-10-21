import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";
import AppModal from "./app-modal";
import { registerVehicle, validateVehicle } from "../service/register-service";
import { FormData } from "../dto/user-dto";

type TModalContent = {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler: () => void;
};

const RegisterForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm<FormData>();
  const password = watch("password");
  const [modalContent, setModalContent] = useState<TModalContent>({
    show: false,
    header: "",
    content: "",
    buttonText: "",
    closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
  });
  const token = localStorage.getItem("token");

  const onSubmit = (data: FormData) => {
    console.log(data);

    registerVehicle(data, token)
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
        console.error("Error registering vehicle:", error.response?.data || error.message);
      });
  };

  const validateChassisNo = () => {
    const chassisNo = watch("chassisNo");

    validateVehicle(chassisNo, token)
      .then((response) => {
        setModalContent({
          show: true,
          header: "Success",
          content: "Validation passed",
          buttonText: "Cancel",
          closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
        });
      })
      .catch((error) => {
        console.error("Error validating vehicle:", error.response?.data || error.message);
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

          <Form.Group className="my-2" as={Row} controlId="nic">
            <Form.Label column sm="2">
              NIC
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter NIC"
                {...register("nic", { required: true })}
                isInvalid={!!errors.nic}
              />
              <Form.Control.Feedback type="invalid">NIC is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="email">
            <Form.Label column sm="2">
              Email
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="email"
                placeholder="Enter email"
                {...register("email", { required: true })}
                isInvalid={!!errors.email}
              />
              <Form.Control.Feedback type="invalid">Email is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="mobile">
            <Form.Label column sm="2">
              Mobile
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter mobile number"
                {...register("mobile", { required: true })}
                isInvalid={!!errors.mobile}
              />
              <Form.Control.Feedback type="invalid">Mobile number is required</Form.Control.Feedback>
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
          <h5>Vehicle Details</h5>
          <Form.Group className="my-2" as={Row} controlId="licensePlate">
            <Form.Label column sm="2">
              License Plate No
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter license plate no"
                {...register("licensePlate", { required: true })}
                isInvalid={!!errors.licensePlate}
              />
              <Form.Control.Feedback type="invalid">License plate number is required</Form.Control.Feedback>
              <Form.Text className="text-muted">Example: ABC-1234 or AB-1234</Form.Text>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="type">
            <Form.Label column sm="2">
              Type
            </Form.Label>
            <Col sm="10">
              <Form.Control as="select" {...register("type", { required: true })} isInvalid={!!errors.type}>
                <option value="">Select type</option>
                <option value="car">Car</option>
                <option value="van">Van</option>
                <option value="bus">Bus</option>
              </Form.Control>
              <Form.Control.Feedback type="invalid">Type is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="registeredYear">
            <Form.Label column sm="2">
              Registered Year
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="number"
                placeholder="Enter registered year"
                {...register("registeredYear", { required: true })}
                isInvalid={!!errors.registeredYear}
              />
              <Form.Control.Feedback type="invalid">Registered year is required</Form.Control.Feedback>
            </Col>
          </Form.Group>

          <Form.Group className="my-2" as={Row} controlId="chassisNo">
            <Form.Label column sm="2">
              Chassis No
            </Form.Label>
            <Col xs="8" sm="8">
              <Form.Control
                type="text"
                placeholder="Enter chassis number"
                {...register("chassisNo", { required: true })}
                isInvalid={!!errors.chassisNo}
              />
              <Form.Control.Feedback type="invalid">Chassis number is required</Form.Control.Feedback>
            </Col>
            <Col xs="4" sm="2">
              <Button variant="secondary" onClick={validateChassisNo}>
                Validate
              </Button>
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
export default RegisterForm;
