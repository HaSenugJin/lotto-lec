package org.example.codingtest.lottos;


import lombok.RequiredArgsConstructor;
import org.example.codingtest._core.errors.exception.Exception400;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LottoService {
    private final LottoRepository lottoRepository;

    @Transactional
    public LottoResponse.LottoSaveDTO save(LottoRequest.LottoSaveDTO lotto) {

        if (lotto.getNumbers().size() != 6) {
            throw new Exception400("6종류의 숫자를 정확히 입력하여 주십시오.");
        }

        List<Integer> duplicates = lotto.getNumbers().stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        if (!duplicates.isEmpty()) {
            throw new Exception400("중복된 숫자가 존재합니다. (중복된 숫자 = " + duplicates + ")");
        }

        lottoRepository.save(lotto.toEntity(lotto.getNumbers()));

        return new LottoResponse.LottoSaveDTO(lotto.getNumbers());
    }
}
