/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class ClienteDestailsImpl implements UserDetailsService {

    private final ClienteService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente user = userService.getByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(int id) {
        Cliente user = userService.findById(id);
        return JwtUserDetails.create(user);
    }
}
