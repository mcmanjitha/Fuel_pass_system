package foe.fuelpass.admin_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/report")
    public String generateReport() {
        // Logic to generate report can be implemented here
        return "Report generated successfully!";
    }

    @GetMapping("/stats")
    public String getStats() {
        // Logic to fetch statistics about users, vehicles, and fuel stations
        return "Statistics fetched successfully!";
    }
}