import React from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";

interface FormData {
  fullName: string;
  nic: string;
  email: string;
  mobile: string;
  licensePlate: string;
  type: string;
  registeredYear: number;
  chassisNo: string;
}

const RegisterForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm<FormData>();
  const onSubmit = (data: FormData) => {
    console.log(data);
  };

  const validateChassisNo = () => {
    const chassisNo = watch("chassisNo");
    // chassis number validation
    alert(`Validating chassis number: ${chassisNo}`);
  };

  return (
    <Form className="p-4" onSubmit={handleSubmit(onSubmit)}>
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
            <Form.Control.Feedback type="invalid">
              Full name is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              NIC is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              Email is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              Mobile number is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              License plate number is required
            </Form.Control.Feedback>
          </Col>
        </Form.Group>

        <Form.Group className="my-2" as={Row} controlId="type">
          <Form.Label column sm="2">
            Type
          </Form.Label>
          <Col sm="10">
            <Form.Control
              as="select"
              {...register("type", { required: true })}
              isInvalid={!!errors.type}
            >
              <option value="">Select type</option>
              <option value="car">Car</option>
              <option value="van">Van</option>
              <option value="bus">Bus</option>
            </Form.Control>
            <Form.Control.Feedback type="invalid">
              Type is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              Registered year is required
            </Form.Control.Feedback>
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
            <Form.Control.Feedback type="invalid">
              Chassis number is required
            </Form.Control.Feedback>
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
  );
};

export default RegisterForm;
