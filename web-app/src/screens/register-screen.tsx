import { Col, Container, Row } from "react-bootstrap";
import RegisterForm from "../components/register-form";

const RegisterScreen = () => {
  return (
    <Container className="py-4">
      <Row>
        <Col>
          <RegisterForm />
        </Col>
      </Row>
    </Container>
  );
};

export default RegisterScreen;
