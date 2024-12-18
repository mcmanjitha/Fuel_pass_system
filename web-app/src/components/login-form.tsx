import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";
import AppModal from "./app-modal";
import { LoginData } from "../dto/user-dto";
import { login } from "../service/login-service";
import QRCodeModal from "./qr-code-modal";

type TModalContent = {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler: () => void;
};

const LoginForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginData>();
  const [modalContent, setModalContent] = useState<TModalContent>({
    show: false,
    header: "",
    content: "",
    buttonText: "",
    closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
  });
  const [showQRcodeModal, setShowQRcodeModal] = useState<boolean>(false);

  const onSubmit = (data: LoginData) => {
    console.log(data);

    login(data)
      .then((response) => {
        setModalContent({
          show: true,
          header: "Success",
          content: "Registration success",
          buttonText: "Cancel",
          closeHandler: () => {
            setModalContent((prev) => ({ ...prev, show: false }));
            setShowQRcodeModal(true);
          },
        });
      })
      .catch((error) => {
        console.error("Error registering vehicle:", error.response?.data || error.message);
      });

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

      <QRCodeModal show={showQRcodeModal} handleClose={() => setShowQRcodeModal(false)} link="http://www.google.com" />
    </React.Fragment>
  );
};

export default LoginForm;
