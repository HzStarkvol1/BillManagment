package org.hzstark.billmanagment.controllers;

import org.hzstark.billmanagment.databases.bills.BillEntity;
import org.hzstark.billmanagment.databases.bills.BillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private final BillRepository repository;

    public DashboardController(BillRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/addBill")
    public String addBill(@ModelAttribute("newBill")BillEntity bill)
    {
        repository.save(bill);
        return "redirect:/dashboard";
    }

    @PostMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable("id") BillEntity bill)
    {
        repository.deleteById(bill.getId());
        return "redirect:/dashboard";
    }
}
