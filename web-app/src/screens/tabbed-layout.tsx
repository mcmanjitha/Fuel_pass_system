import { Tab, Tabs } from "react-bootstrap";
import RegisterScreen from "./register-screen";
import LoginScreen from "./login-screen";
import FuelStationRegisterScreen from "./fuel-station-registration";

const TabbedLayout = () => {
  return (
    <Tabs defaultActiveKey="register" id="tabbed-layout" fill>
      <Tab eventKey="register" title="User Registration">
        <RegisterScreen />
      </Tab>

      <Tab eventKey="login" title="User Login">
        <LoginScreen />
      </Tab>

      <Tab eventKey="fuel-register" title="Fuel Station Registration">
        <FuelStationRegisterScreen />
      </Tab>

      <Tab eventKey="administration" title="Administration" disabled>
        Tab content for Loooonger Tab
      </Tab>
    </Tabs>
  );
};

export default TabbedLayout;
