package org.hzstark.billmanagment.controllers;

import org.hzstark.billmanagment.databases.users.UserEntity;
import org.hzstark.billmanagment.databases.users.UserRepository;
import org.hzstark.billmanagment.databases.users.admin.AdminEntity;
import org.hzstark.billmanagment.databases.users.admin.AdminRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogInController {
    UserRepository repository;
    AdminRepository adminRepository;

    public LogInController(UserRepository repository, AdminRepository adminRepository)
    {
        this.repository = repository;
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public String userTest(@ModelAttribute("user") UserEntity user)
    {
        if(repository.existsByUsername(user.getUsername()) && repository.existsByPassword(user.getPassword()))
        {
            if (user.getUsername().equals("Admin"))
            {
                return "redirect:/";
            }
            else {
                System.out.println("User has been logged in");
                return "redirect:/dashboard";
            }
        }
        else{
            System.out.println("Username or password is incorrect");
            return "redirect:/";
        }
    }

    @PostMapping("/adminlogin")
    public String adminLogin(@ModelAttribute("admin") AdminEntity admin, Model model)
    {
        if(adminRepository.existsByUsername(admin.getUsername()) && adminRepository.existsByPassword(admin.getPassword()))
        {
            System.out.println("Logged in as Admin!");
            return "redirect:/admin/dashboard";
        }
        else
        {
            model.addAttribute("user",new UserEntity());
            model.addAttribute("admin",new AdminEntity());
            return "accountpage";
        }
    }
}
