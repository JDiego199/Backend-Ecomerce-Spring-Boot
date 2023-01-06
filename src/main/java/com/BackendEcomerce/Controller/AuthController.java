/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.request.ClienteCreateRequest;
import com.BackendEcomerce.request.ClienteLoginRequest;
import com.BackendEcomerce.security.JwtTokenProvider;
import com.BackendEcomerce.service.ClienteService;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mota1
 */

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final ClienteService userService;

    private final PasswordEncoder passwordEncoder;

   // private final SendEmailService sendEmailService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, ClienteService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager =authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;

    }

    @PostMapping("/login")
    public String login(@RequestBody ClienteLoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        
        Cliente user = userService.getByUserName(loginRequest.getUserName());
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateAccessToken(user);
        //Cliente user = userService.getByUserName(loginRequest.getUserName());
       // sendEmailService.sendEmails(user.getEMail(), ECommerceMessage.LOGIN_BODY, ECommerceMessage.LOGIN_TOPIC);
        return "Bearer " + jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ClienteCreateRequest user) throws AddressException {
      //  if(userService.findByEMail(user.getEMail()) != null) {
    //        return new ResponseEntity<>(ECommerceMessage.EMAIL_ALREADY_IN_USE, HttpStatus.BAD_REQUEST);
      //  }

        Cliente newUser = new Cliente();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
       
               
     
       // newUser.setEMail(user.getEMail());
       // newUser.setUserCreateDate(new Date());
        userService.save(newUser);
      //  sendEmailService.sendEmails(String.valueOf(user.getEMail()), ECommerceMessage.REGISTER_BODY, ECommerceMessage.REGISTER_TOPIC + ECommerceMessage.REGISTER_TOPIC_EMOJI);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

/*    @DeleteMapping("/deleteByUser")
    public ResponseEntity<?> deleteByUser(@RequestBody UserDeleteRequest userDeleteRequest) {
        userService.authDeleteByUser(userDeleteRequest);
        sendEmailService.sendEmails(userDeleteRequest.getEMail(), ECommerceMessage.AUTH_DELETE_BODY, ECommerceMessage.AUTH_DELETE_TOPIC + ECommerceMessage.AUTH_DELETE_TOPIC_EMOJI);
        return new ResponseEntity<>(ECommerceMessage.USER_DELETED, HttpStatus.OK);
    }*/
}
