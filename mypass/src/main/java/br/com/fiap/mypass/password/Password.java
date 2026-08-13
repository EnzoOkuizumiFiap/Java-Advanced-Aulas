package br.com.fiap.mypass.password;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String username;
    private String password;
}
