package com.BackendEcomerce.security.dto;



import com.BackendEcomerce.security.entity.Rol;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginUsuario {

    @NotBlank
        String userName;
     @NotBlank
    String password;
     
    
     
     
   



}
