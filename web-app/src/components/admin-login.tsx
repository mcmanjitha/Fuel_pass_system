import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Button, Form, Row, Col } from "react-bootstrap";
import AppModal from "./app-modal";
import { AdminData } from "../dto/user-dto";

type TModalContent = {
  show: boolean;
  header: string;
  content: string;
  buttonText: string;
  closeHandler: () => void;
};

interface IProps {
  setAuthentication: () => void;
}

const AdminLogin: React.FC<IProps> = ({ setAuthentication }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<AdminData>();
  const [modalContent, setModalContent] = useState<TModalContent>({
    show: false,
    header: "",
    content: "",
    buttonText: "",
    closeHandler: () => setModalContent((prev) => ({ ...prev, show: false })),
  });

  const onSubmit = (data: AdminData) => {
    console.log(data);
    setAuthentication();
    // login(data)
    //   .then((response) => {
    //     setModalContent({
    //       show: true,
    //       header: "Success",
    //       content: "Registration success",
    //       buttonText: "Cancel",
    //       closeHandler: () => {
    //         setModalContent((prev) => ({ ...prev, show: false }));
    //         setShowQRcodeModal(true);
    //       },
    //     });
    //   })
    //   .catch((error) => {
    //     console.error("Error registering vehicle:", error.response?.data || error.message);
    //   });

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
          <Form.Group className="my-2" as={Row} controlId="adminID">
            <Form.Label column sm="2">
              Admin ID
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter Admin ID"
                {...register("adminID", { required: true })}
                isInvalid={!!errors.adminID}
              />
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

export default AdminLogin;
