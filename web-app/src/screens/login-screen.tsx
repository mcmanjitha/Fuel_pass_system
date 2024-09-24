import { Col, Container, Row } from "react-bootstrap";
import LoginForm from "../components/login-form";

const LoginScreen = () => {
  return (
    <Container className="py-4">
      <Row>
        <Col>
          <LoginForm />
        </Col>
      </Row>
    </Container>
  );
};

export default LoginScreen;
