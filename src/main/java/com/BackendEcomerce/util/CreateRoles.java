package com.BackendEcomerce.util;


import com.BackendEcomerce.security.entity.Rol;
import com.BackendEcomerce.security.enums.RolNombre;
import com.BackendEcomerce.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

 /*
@Component
public class CreateRoles implements CommandLineRunner {

   @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolEmpresa = new Rol(RolNombre.ROLE_EMPRESA);
        rolService.save(rolEmpresa);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
} */
