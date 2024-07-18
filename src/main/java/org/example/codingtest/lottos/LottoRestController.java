package org.example.codingtest.lottos;

import lombok.RequiredArgsConstructor;
import org.example.codingtest._core.utils.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LottoRestController {

    private final LottoService lottoService;

    @PostMapping("/lottos")
    public ResponseEntity<?> save(@RequestBody LottoRequest.LottoSaveDTO lotto) {

        LottoResponse.LottoSaveDTO respDTO = lottoService.save(lotto);

        return ResponseEntity.ok(respDTO);
    }
}
