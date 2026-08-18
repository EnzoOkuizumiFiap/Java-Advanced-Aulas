package br.com.fiap.fiapmovies.domain.watchlist;

import br.com.fiap.fiapmovies.domain.movies.MovieRepository;
import br.com.fiap.fiapmovies.domain.users.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.security.oauth2.server.resource.autoconfigure.OAuth2ResourceServerProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchlist")
@RequiredArgsConstructor
public class WatchlistEntryController {
    private final WatchlistEntryRepository watchlistEntryRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public record WatchlistEntryRequest(Long movieId, WatchlistStatus status) {}

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public WatchlistEntry save(
            @RequestBody @Valid WatchlistEntryRequest request,
            @AuthenticationPrincipal Jwt jwt
    ) {
        var user = userRepository.findByUsername(jwt.getSubject()).get();
        var movie = movieRepository.getReferenceById(request.movieId());
        return watchlistEntryRepository.save(WatchlistEntry.builder()
                .user(user)
                .movie(movie)
                .status(request.status())
                .build());
    }

}