package org.example.codingtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codingtest._core.utils.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> join(@Valid @RequestBody UserRequest.JoinDTO reqDTO, Errors errors) {

        UserResponse.JoinDTO respDTO = userService.join(reqDTO);

        return ResponseEntity.ok(respDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id, @RequestParam("name") String name) {

        UserResponse.GetUserDTO user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> userUpdate(@PathVariable("id") Long id, @Valid @RequestBody UserRequest.UpdateDTO reqDTO, Errors errors) {

        UserResponse.UpdateDTO respDTO = userService.update(id, reqDTO);

        return ResponseEntity.ok(respDTO);
    }
}
