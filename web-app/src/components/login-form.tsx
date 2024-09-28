import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";
import AppModal from "./app-modal";

type TModalContent = {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler: () => void;
};

interface FormData {
  licensePlateNo: string;
  password: string;
}

const LoginForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();
  const [modalContent, setModalContent] = useState<TModalContent>({
    show: false,
    header: "",
    content: "",
    buttonText: "",
    closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
  });

  const onSubmit = (data: FormData) => {
    console.log(data);

    setModalContent({
      show: true,
      header: "Success",
      content: "Login success",
      buttonText: "Cancel",
      closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
    });
  };

  return (
    <React.Fragment>
      <Form className="p-1" onSubmit={handleSubmit(onSubmit)}>
        <h2>Login</h2>

        <section>
          <Form.Group className="my-2" as={Row} controlId="licensePlateNo">
            <Form.Label column sm="2">
              License plate No
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter license plate no"
                {...register("licensePlateNo", { required: true })}
                isInvalid={!!errors.licensePlateNo}
              />
              <Form.Control.Feedback type="invalid">License plate number is required</Form.Control.Feedback>
              <Form.Text className="text-muted">Example: ABC-1234 or AB-1234</Form.Text>
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
                {...register("password", { required: true })}
                isInvalid={!!errors.password}
              />
              <Form.Control.Feedback type="invalid">Password is required</Form.Control.Feedback>
            </Col>
          </Form.Group>
        </section>

        <Button variant="primary" type="submit">
          Login
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

export default LoginForm;
