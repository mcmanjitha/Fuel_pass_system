package architecture.project.fuetstation.service;


import architecture.project.fuetstation.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{

    public String login(Admin admin)
    {
        return "Success";
    }
}
