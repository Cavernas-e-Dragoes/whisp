package com.ced.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class User {

    @Size(min = 4, max = 100, message = "O campo 'name' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'name' nao pode ser nulo ou vazio")
    private String name;
    @Size(min = 4, max = 100, message = "O campo 'email' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'email' nao pode ser nulo ou vazio")
    private String email;
    @Size(min = 4, max = 100, message = "O campo 'password' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'password' nao pode ser nulo ou vazio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public @Size(min = 4, max = 100, message = "O campo 'name' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'name' nao pode ser nulo ou vazio") String getName() {
        return name;
    }

    public void setName(@Size(min = 4, max = 100, message = "O campo 'name' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'name' nao pode ser nulo ou vazio") String name) {
        this.name = name;
    }

    public @Size(min = 4, max = 100, message = "O campo 'email' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'email' nao pode ser nulo ou vazio") String getEmail() {
        return email;
    }

    public void setEmail(@Size(min = 4, max = 100, message = "O campo 'email' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'email' nao pode ser nulo ou vazio") String email) {
        this.email = email;
    }

    public @Size(min = 4, max = 100, message = "O campo 'password' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'password' nao pode ser nulo ou vazio") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 4, max = 100, message = "O campo 'password' deve ter entre 4 e 100 caracteres") @NotBlank(message = "O campo 'password' nao pode ser nulo ou vazio") String password) {
        this.password = password;
    }
}
