package com.BackendEcomerce.security.service;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.security.entity.UsuarioMain;
import com.BackendEcomerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Clase que convierte la clase usuario en un UsuarioMain
 * UserDetailsService es propia de Spring Security
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
   ClienteService usuarioService;

   @Override
   public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
      Cliente usuario = usuarioService.getByUserName(nombreUsuario).get();
      return UsuarioMain.build(usuario);
   }
}
