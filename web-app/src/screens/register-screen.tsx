import { Col, Container, Row } from "react-bootstrap";
import RegisterForm from "../components/register-form";

const RegisterScreen = () => {
  return (
    <Container className="py-4">
      <Row className="justify-content-center">
        <Col className="col-auto">
          <img src="/assets/logo.png" alt="logo" width={36} height={36} />
        </Col>
        <Col className="col-auto">
          <h2 className="text-center m-0">Welcome to Fuel Pass</h2>
        </Col>
      </Row>

      <Row>
        <Col>
          <RegisterForm />
        </Col>
      </Row>
    </Container>
  );
};

export default RegisterScreen;
