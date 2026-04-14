package fiap.com.br.music.genre;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) //nullable é not null / unique é para ele ser único
    private String name;

    //Construtor
    public Genre(String name) {
        this.name = name;
    }
}
