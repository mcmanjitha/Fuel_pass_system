import { Col, Container, Row } from "react-bootstrap";
import FuelStationRegisterForm from "../components/fuel-station-registration";

const FuelStationRegisterScreen = () => {
  return (
    <Container className="py-4">
      <Row>
        <Col>
          <FuelStationRegisterForm />
        </Col>
      </Row>
    </Container>
  );
};

export default FuelStationRegisterScreen;
