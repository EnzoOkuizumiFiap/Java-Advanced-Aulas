package br.com.fiap.fiapmovies.domain.watchlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistEntryRepository extends JpaRepository<WatchlistEntry, Long> {
}
