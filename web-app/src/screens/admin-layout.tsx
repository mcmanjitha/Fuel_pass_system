import React, { useState } from "react";
import { Container } from "react-bootstrap";
import AdminLogin from "../components/admin-login";
import AdminPanel from "./admin-panel";

const AdminLayout = () => {
  const [adminAuthenticated, setAdminAuthenticated] = useState<boolean>(false);

  return (
    <Container>
      {!adminAuthenticated ? (
        <AdminLogin setAuthentication={() => setAdminAuthenticated(true)} />
      ) : (
        <AdminPanel setAuthentication={() => setAdminAuthenticated(false)} />
      )}
    </Container>
  );
};

export default AdminLayout;
