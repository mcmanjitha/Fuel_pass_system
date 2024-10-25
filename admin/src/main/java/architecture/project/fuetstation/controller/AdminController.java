package architecture.project.fuetstation.controller;

import architecture.project.fuetstation.model.Admin;
import architecture.project.fuetstation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestBody Admin admin)
    {
        return adminService.verify(admin);
    }
}
