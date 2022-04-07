package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    private String clientId;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Surname can not be empty")
    @Size(min = 2, max = 16, message = "Surname must be greater than 2 and less than 16")
    private String surname;
    private String company;
    private String position;
    @Email(message = "Incorrect email")
    private String email;
    private double salary;
}
