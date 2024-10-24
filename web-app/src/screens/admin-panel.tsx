import React, { useState } from "react";
import { Navbar, Nav, Container, Row, Col, Table, Button } from "react-bootstrap";
import { FaBars } from "react-icons/fa";
import "./admin-panel.css";
import { FaPowerOff } from "react-icons/fa";

interface IProps {
  setAuthentication: () => void;
}

const AdminPanel: React.FC<IProps> = ({ setAuthentication }) => {
  const [activeTab, setActiveTab] = useState<string | null>("user");
  const [showNav, setShowNav] = useState(true);

  const handleSelect = (selectedKey: string | null) => {
    setActiveTab(selectedKey);
    setShowNav(false);
  };

  const toggleNav = () => setShowNav(!showNav);

  const renderTable = () => {
    if (activeTab === "user") {
      return (
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>John Doe</td>
              <td>johndoe@example.com</td>
              <td>123-456-7890</td>
            </tr>
          </tbody>
        </Table>
      );
    } else if (activeTab === "vehicle") {
      return (
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>Vehicle Name</th>
              <th>Model</th>
              <th>License Plate</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Tesla Model S</td>
              <td>2022</td>
              <td>XYZ-1234</td>
            </tr>
          </tbody>
        </Table>
      );
    } else if (activeTab === "station") {
      return (
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>Station Name</th>
              <th>Location</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Station A</td>
              <td>New York</td>
              <td>Active</td>
            </tr>
          </tbody>
        </Table>
      );
    }
  };

  return (
    <Container fluid>
      <Row>
        <Col
          xs={showNav ? 12 : 0}
          md={2}
          className={`d-md-block bg-light p-0 ${showNav ? "position-relative" : "d-none"} h-md-100`}
        >
          <Navbar bg="light" expand="md" className="flex-column" style={{ height: "100%" }}>
            <Nav className="flex-column" onSelect={handleSelect} style={{ padding: "1rem" }}>
              <Nav.Link eventKey="user">User Info</Nav.Link>
              <Nav.Link eventKey="vehicle">Vehicle Info</Nav.Link>
              <Nav.Link eventKey="station">Station Info</Nav.Link>
              <Nav.Link>
                <FaPowerOff onClick={setAuthentication} />
              </Nav.Link>
            </Nav>
          </Navbar>
        </Col>

        <Col xs={12} className="d-md-none">
          <Button variant="light" onClick={toggleNav} className="my-3">
            <FaBars /> Menu
          </Button>
        </Col>

        <Col xs={12} md={10} className="p-3">
          {renderTable()}
        </Col>
      </Row>
    </Container>
  );
};

export default AdminPanel;
