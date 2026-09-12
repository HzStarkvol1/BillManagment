package org.hzstark.billmanagment.controllers;

import org.hzstark.billmanagment.databases.bills.BillEntity;
import org.hzstark.billmanagment.databases.bills.BillRepository;
import org.hzstark.billmanagment.databases.users.UserEntity;
import org.hzstark.billmanagment.databases.users.admin.AdminEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final BillRepository repository;

    public MainController(BillRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/")
    public String homePage(Model model)
    {
        model.addAttribute("user",new UserEntity());
        model.addAttribute("admin",new AdminEntity());
        return "accountpage";
    }
    @GetMapping("/dashboard")
    public String dashboardPage(Model model)
    {
        model.addAttribute("newBill", new BillEntity());
        model.addAttribute("billsList", repository.findAll());
        return "dashboard";
    }
}
