package org.hzstark.billmanagment.controllers;

import org.hzstark.billmanagment.databases.users.UserEntity;
import org.hzstark.billmanagment.databases.users.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {

    private final UserRepository userRepository;

    public AdminDashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Dashboard ekranını açarken gerekli nesneleri yolluyoruz
    @GetMapping
    public String showDashboard(Model model) {
        // Üye listesi için veritabanındaki tüm kullanıcıları çekiyoruz
        model.addAttribute("usersList", userRepository.findAll());
        // Yeni eklenecek üye formunu tutması için boş bir framework nesnesi yolluyoruz
        model.addAttribute("newUser", new UserEntity());
        
        return "admindashboard"; // admindashboard.html sayfasını açar
    }

    // Yeni üye eklendiğinde çalışacak POST metodu
    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("newUser") UserEntity user) {
        userRepository.save(user); // Kullanıcıyı Users tablosuna kaydet
        return "redirect:/admin/dashboard"; // Sayfayı yenilet (GET isteğine geri yönlendir)
    }

    // Üye silindiğinde çalışacak POST metodu
    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id); // Kullanıcıyı ID'sine göre Users tablosundan sil
        return "redirect:/admin/dashboard"; // Sayfayı yenilet
    }
}
