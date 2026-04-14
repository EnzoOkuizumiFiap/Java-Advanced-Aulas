package fiap.com.br.music.album;

import fiap.com.br.music.artist.Artist;
import fiap.com.br.music.music.Music;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private Integer releaseYear;

    //Primariamente ele não busca o artista, mas sim os dados do Album, se precisar dos dados do artista, ele faz depois
    //@ManyToOne(fetch = FetchType.LAZY) Ao buscar os dados do artista, ele vai ser preguiçoso.
    //@ManyToOne(cascade = CascadeType.ALL) É como vai refletir nos dados associados do objeto pai para o objeto filho
    @ManyToOne
    private Artist artist;

    //@OneToMany(orphanRemoval = true) Ao remover o álbum, ele vai remover a lista de músicas
    @OneToMany
    private List<Music> musics;
}
