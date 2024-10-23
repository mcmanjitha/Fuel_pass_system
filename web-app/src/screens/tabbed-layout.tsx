import { Tab, Tabs } from "react-bootstrap";
import RegisterScreen from "./register-screen";
import LoginScreen from "./login-screen";

const TabbedLayout = () => {
  return (
    <Tabs defaultActiveKey="register" id="tabbed-layout" fill>
      <Tab eventKey="register" title="Register Form">
        <RegisterScreen />
      </Tab>

      <Tab eventKey="login" title="Login Form">
        <LoginScreen />
      </Tab>

      <Tab eventKey="administration" title="Administration" disabled>
        Tab content for Loooonger Tab
      </Tab>
    </Tabs>
  );
};

export default TabbedLayout;
