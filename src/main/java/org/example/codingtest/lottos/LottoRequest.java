package org.example.codingtest.lottos;

import lombok.Data;

import java.util.List;

public class LottoRequest {

    @Data
    public static class LottoSaveDTO {
        private List<Integer> numbers;

        public Lotto toEntity(List<Integer> numbers) {
            return Lotto.builder()
                    .numberOne(numbers.get(0))
                    .numberTwo(numbers.get(1))
                    .numberThree(numbers.get(2))
                    .numberFour(numbers.get(3))
                    .numberFive(numbers.get(4))
                    .numberSix(numbers.get(5))
                    .build();
        }
    }
}
