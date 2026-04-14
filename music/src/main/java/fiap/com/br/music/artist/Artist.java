package fiap.com.br.music.artist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fiap.com.br.music.album.Album;
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
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    private String country;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;
}
