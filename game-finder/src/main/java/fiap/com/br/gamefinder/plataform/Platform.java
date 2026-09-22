package fiap.com.br.gamefinder.plataform;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "platforms")
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
