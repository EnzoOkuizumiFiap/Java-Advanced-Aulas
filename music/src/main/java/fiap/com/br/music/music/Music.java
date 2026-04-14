package fiap.com.br.music.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fiap.com.br.music.album.Album;
import fiap.com.br.music.genre.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private Integer durationSeconds; //wrappers - começar a usar o Integer, pois é melhor que os primitivos!

    @ManyToMany
    private List<Genre> genres;

    @ManyToOne(optional = false)
    @JsonIgnore
    private Album album;
}
