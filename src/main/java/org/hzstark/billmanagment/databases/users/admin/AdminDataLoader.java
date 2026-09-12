package org.hzstark.billmanagment.databases.users.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminDataLoader {

    @Bean
    public CommandLineRunner loadDefaultAdmin(AdminRepository adminRepository) {
        return args -> {
            // Eğer "Admin" adında bir kullanıcı yoksa varsayılan veriyi kaydet
            if (!adminRepository.existsByUsername("Admin")) {
                adminRepository.save(new AdminEntity("Admin", "123admin"));
                System.out.println("Varsayılan admin hesabı oluşturuldu. (username: Admin, password: 123admin)");
            } else {
                System.out.println("Varsayılan admin hesabı zaten mevcut.\nusername: Admin\npassword: 123admin");
            }
        };
    }
}
