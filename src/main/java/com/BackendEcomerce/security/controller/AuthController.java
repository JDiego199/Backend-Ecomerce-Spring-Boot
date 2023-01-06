package com.BackendEcomerce.security.controller;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.request.ClienteCreateRequest;
import com.BackendEcomerce.security.dto.JwtDto;
import com.amoelcodigo.crud.dto.Mensaje;
import com.BackendEcomerce.security.dto.LoginUsuario;
import com.BackendEcomerce.security.dto.NuevoUsuario;
import com.BackendEcomerce.security.entity.Rol;
import com.BackendEcomerce.security.enums.RolNombre;
import com.BackendEcomerce.security.jwt.JwtProvider;
import com.BackendEcomerce.security.service.RolService;
import com.BackendEcomerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ClienteService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //Espera un json y lo convierte a tipo clase NuevoUsuario
    @PostMapping("/register")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody ClienteCreateRequest nuevoUsuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
        }
        /*  if(usuarioService.existsByUsuario(nuevoUsuario.getUserName())){
            return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }*/
 /*  if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }*/

        Cliente newUser = new Cliente();
        newUser.setUserName(nuevoUsuario.getUserName());
        newUser.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        newUser.setRoles(roles);
        //  roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        switch (nuevoUsuario.getRol()) {
            case "admin":
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

                usuarioService.save(newUser);

                return new ResponseEntity<>(new Mensaje("Usuario Admin creado"), HttpStatus.CREATED);

            case "cliente":
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

                usuarioService.save(newUser);

                return new ResponseEntity<>(new Mensaje("Usuario Cliente creado"), HttpStatus.CREATED);
            case "empresa":
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_EMPRESA).get());

                usuarioService.save(newUser);

                return new ResponseEntity<>(new Mensaje("Usuario Empresa creado"), HttpStatus.CREATED);
            default:
                return new ResponseEntity<>(new Mensaje("Usuario no creado"), HttpStatus.CREATED);

        }

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication
                = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getUserName(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}
