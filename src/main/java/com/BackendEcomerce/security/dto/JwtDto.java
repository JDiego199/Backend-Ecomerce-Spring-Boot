package com.BackendEcomerce.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {

   private String token;
   private String bearer = "Bearer";
   private String nombreUsuario;
   private Integer id;
   private Collection<? extends GrantedAuthority> authorities;


   public JwtDto(String token, String nombreUsuario, Integer id, Collection<? extends GrantedAuthority> authorities) {
      this.token = token;
      this.nombreUsuario = nombreUsuario;
      this.id = id;
      this.authorities = authorities;

   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public String getBearer() {
      return bearer;
   }

   public void setBearer(String bearer) {
      this.bearer = bearer;
   }

   public String getNombreUsuario() {
      return nombreUsuario;
   }

   public void setNombreUsuario(String nombreUsuario) {
      this.nombreUsuario = nombreUsuario;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
      this.authorities = authorities;
   }
}
