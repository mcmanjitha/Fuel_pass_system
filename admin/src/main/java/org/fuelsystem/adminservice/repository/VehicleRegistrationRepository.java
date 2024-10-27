package org.fuelsystem.adminservice.repository;

import org.fuelsystem.adminservice.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, String> {
}
