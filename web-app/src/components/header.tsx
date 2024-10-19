import { Col, Row } from "react-bootstrap";

const Header = () => {
  return (
    <Row className="justify-content-center mt-2 mb-5 mx-0">
      <Col className="col-auto">
        <img src="/assets/logo.png" alt="logo" width={36} height={36} />
      </Col>
      <Col className="col-auto">
        <h2 className="text-center m-0">Welcome to Fuel Pass</h2>
      </Col>
    </Row>
  );
};

export default Header;
