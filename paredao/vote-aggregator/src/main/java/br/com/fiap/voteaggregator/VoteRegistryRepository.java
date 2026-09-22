package br.com.fiap.voteaggregator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRegistryRepository extends JpaRepository<VoteRegistry,  String> {
}
