package recipes.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp="\\w+@\\w+\\.\\w+", message="Please provide a valid email address")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "password length must be at least 8 characters")
    private String password;
}
