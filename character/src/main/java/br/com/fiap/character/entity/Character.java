package br.com.fiap.character.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "characters")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String className;
    private Integer level;
    private double hp;
    private LocalDate createdAt;
    private String characterCode;
}
