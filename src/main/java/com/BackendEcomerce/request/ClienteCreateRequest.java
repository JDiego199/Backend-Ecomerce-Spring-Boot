/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.request;

/**
 *
 * @author mota1
 */
import com.BackendEcomerce.security.entity.Rol;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteCreateRequest {
        String userName;
        String password;
           String rol;
         private Set<String> roles = new HashSet<>();
}
