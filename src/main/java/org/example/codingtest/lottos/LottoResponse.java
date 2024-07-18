package org.example.codingtest.lottos;

import lombok.Data;

import java.util.List;

public class LottoResponse {

    @Data
    public static class LottoSaveDTO {
        private List<Integer> numbers;

        public LottoSaveDTO(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
