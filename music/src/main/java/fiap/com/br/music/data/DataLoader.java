package fiap.com.br.music.data;

import fiap.com.br.music.album.Album;
import fiap.com.br.music.album.AlbumRepository;
import fiap.com.br.music.artist.Artist;
import fiap.com.br.music.artist.ArtistRepository;
import fiap.com.br.music.genre.Genre;
import fiap.com.br.music.genre.GenreRepository;
import fiap.com.br.music.music.Music;
import fiap.com.br.music.music.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    //seeder database - data loader
    private final GenreRepository genreRepository;
    private final MusicRepository musicRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    @Override
    public void run(String... args) {
        if (genreRepository.count() > 0 || artistRepository.count() > 0 || albumRepository.count() > 0 || musicRepository.count() > 0) {
            return;
        }

        var pop = new Genre("Pop");
        var rock = new Genre("Rock");
        var samba = new Genre("Samba");
        var funk = new Genre("Funk");
        var sertanejo = new Genre("Sertanejo");
        var mpb = new Genre("MPB");
        var hipHop = new Genre("Hip Hop");
        var eletronica = new Genre("Eletronica");
        var jazz = new Genre("Jazz");
        var reggae = new Genre("Reggae");

        genreRepository.saveAll(List.of(pop, rock, samba, funk, sertanejo, mpb, hipHop, eletronica, jazz, reggae));

        var savedArtists = artistRepository.saveAll(List.of(
                Artist.builder().name("Anitta").country("Brazil").build(),
                Artist.builder().name("Shakira").country("Colombia").build(),
                Artist.builder().name("Drake").country("Canada").build(),
                Artist.builder().name("Dua Lipa").country("United Kingdom").build(),
                Artist.builder().name("Rosalia").country("Spain").build(),
                Artist.builder().name("Stromae").country("Belgium").build(),
                Artist.builder().name("BTS").country("South Korea").build(),
                Artist.builder().name("Daft Punk").country("France").build(),
                Artist.builder().name("Sia").country("Australia").build(),
                Artist.builder().name("Rema").country("Nigeria").build()
        ));

        var savedAlbums = albumRepository.saveAll(List.of(
                Album.builder().title("Global Beats Vol 1").releaseYear(2020).artist(savedArtists.get(0)).build(),
                Album.builder().title("Rock e Rua").releaseYear(2018).artist(savedArtists.get(2)).build(),
                Album.builder().title("Raizes do Brasil").releaseYear(2019).artist(savedArtists.get(1)).build(),
                Album.builder().title("Noite Urbana").releaseYear(2022).artist(savedArtists.get(3)).build(),
                Album.builder().title("Vibes de Verao").releaseYear(2023).artist(savedArtists.get(9)).build()
        ));

        var album1 = savedAlbums.get(0);
        var album2 = savedAlbums.get(1);
        var album3 = savedAlbums.get(2);
        var album4 = savedAlbums.get(3);
        var album5 = savedAlbums.get(4);

        musicRepository.saveAll(List.of(
                Music.builder().title("Caneta Azul").durationSeconds(120).genres(List.of(pop)).album(album1).build(),
                Music.builder().title("Noite de Verao").durationSeconds(188).genres(List.of(pop, eletronica)).album(album1).build(),
                Music.builder().title("Cidade Neon").durationSeconds(204).genres(List.of(pop)).album(album1).build(),
                Music.builder().title("Estrada de Pedra").durationSeconds(230).genres(List.of(rock)).album(album2).build(),
                Music.builder().title("Guitarra em Chamas").durationSeconds(246).genres(List.of(rock)).album(album2).build(),
                Music.builder().title("Vento do Sul").durationSeconds(212).genres(List.of(rock, reggae)).album(album2).build(),
                Music.builder().title("Batucada da Praca").durationSeconds(195).genres(List.of(samba)).album(album3).build(),
                Music.builder().title("Roda Ate Amanhecer").durationSeconds(225).genres(List.of(samba, mpb)).album(album3).build(),
                Music.builder().title("Passo de Carnaval").durationSeconds(178).genres(List.of(samba)).album(album3).build(),
                Music.builder().title("Pancada no Grave").durationSeconds(167).genres(List.of(funk)).album(album4).build(),
                Music.builder().title("Baile da Meia Noite").durationSeconds(181).genres(List.of(funk, hipHop)).album(album4).build(),
                Music.builder().title("Ritmo de Favela").durationSeconds(173).genres(List.of(funk)).album(album4).build(),
                Music.builder().title("Chapeu e Violao").durationSeconds(210).genres(List.of(sertanejo)).album(album3).build(),
                Music.builder().title("Saudade da Roca").durationSeconds(238).genres(List.of(sertanejo)).album(album3).build(),
                Music.builder().title("Lua no Interior").durationSeconds(219).genres(List.of(sertanejo, mpb)).album(album3).build(),
                Music.builder().title("Janela da Alma").durationSeconds(227).genres(List.of(mpb)).album(album3).build(),
                Music.builder().title("Tarde em Ipanema").durationSeconds(241).genres(List.of(mpb, jazz)).album(album3).build(),
                Music.builder().title("Carta sem Fim").durationSeconds(214).genres(List.of(mpb)).album(album3).build(),
                Music.builder().title("Rima na Avenida").durationSeconds(190).genres(List.of(hipHop)).album(album4).build(),
                Music.builder().title("Linha de Frente").durationSeconds(201).genres(List.of(hipHop)).album(album4).build(),
                Music.builder().title("Flow Tropical").durationSeconds(186).genres(List.of(hipHop, reggae)).album(album5).build(),
                Music.builder().title("Pulso Digital").durationSeconds(209).genres(List.of(eletronica)).album(album1).build(),
                Music.builder().title("Frequencia Alta").durationSeconds(216).genres(List.of(eletronica, pop)).album(album1).build(),
                Music.builder().title("Luzes da Madrugada").durationSeconds(223).genres(List.of(eletronica)).album(album1).build(),
                Music.builder().title("Blue da Esquina").durationSeconds(252).genres(List.of(jazz)).album(album3).build(),
                Music.builder().title("Solo em Veludo").durationSeconds(268).genres(List.of(jazz)).album(album3).build(),
                Music.builder().title("Cafe e Sax").durationSeconds(244).genres(List.of(jazz, mpb)).album(album3).build(),
                Music.builder().title("Mare Positiva").durationSeconds(207).genres(List.of(reggae)).album(album5).build(),
                Music.builder().title("Ilha do Som").durationSeconds(199).genres(List.of(reggae)).album(album5).build(),
                Music.builder().title("Brisa e Contratempo").durationSeconds(215).genres(List.of(reggae, rock)).album(album5).build()
        ));
    }
}
