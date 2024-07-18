package org.example.codingtest.lottos;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "lotto_tb")
@Entity
public class Lotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer numberOne;
    Integer numberTwo;
    Integer numberThree;
    Integer numberFour;
    Integer numberFive;
    Integer numberSix;

    @Builder
    public Lotto(Long id, Integer numberOne, Integer numberTwo, Integer numberThree, Integer numberFour, Integer numberFive, Integer numberSix) {
        this.id = id;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.numberFour = numberFour;
        this.numberFive = numberFive;
        this.numberSix = numberSix;
    }
}
