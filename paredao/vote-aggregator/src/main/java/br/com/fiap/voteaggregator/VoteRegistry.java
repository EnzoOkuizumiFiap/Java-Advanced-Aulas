package br.com.fiap.voteaggregator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteRegistry {
    @Id
    private String participanteId;
    private Integer totalVotes;
}
