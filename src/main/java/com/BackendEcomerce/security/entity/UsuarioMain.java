package com.BackendEcomerce.security.entity;

import com.BackendEcomerce.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase Encargada de generar la seguridad
 * Clase que implementa los privilegios de cada usuario
 * UserDetails es una clase propia de Spring Security
 */
    @Getter
@Setter
public class UsuarioMain implements UserDetails {

   public int id;
    private String userName;
    private String password;
    // Variable que nos da la autorización (no confundir con autenticación)
    // Coleccion de tipo generico que extendiende
    // de GranthedAuthority de Spring security
    private Collection<? extends GrantedAuthority> authorities;

    //Constructor

    public UsuarioMain(int id, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    //Metodo que asigna los privilegios (autorización)
    public static UsuarioMain build(Cliente usuario){
        //Convertimos la clase Rol a la clase GrantedAuthority
        List<GrantedAuthority> authorities =
                usuario.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioMain(usuario.getId_cliente(),usuario.getUserName(), 
                usuario.getPassword(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

   @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
