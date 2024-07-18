package org.example.codingtest.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codingtest._core.errors.exception.Exception400;
import org.example.codingtest._core.errors.exception.Exception404;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public UserResponse.JoinDTO join(UserRequest.JoinDTO reqDTO) {

        // 유저네임 중복체크
        User userName = userRepository.findByName(reqDTO.getName());

        if (userName != null) {
            throw new Exception400("유저네임이 중복되었습니다.");
        }

        User user = userRepository.save(reqDTO.toEntity());

        return new UserResponse.JoinDTO(user);
    }

    public UserResponse.GetUserDTO getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception404("존재하지 않는 유저입니다."));
        return new UserResponse.GetUserDTO(user);
    }

    @Transactional
    public UserResponse.UpdateDTO update(Long id, UserRequest.UpdateDTO reqDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception400("존재하지 않는 유저입니다."));

        user.setName(reqDTO.getName());

        return new UserResponse.UpdateDTO(user);
    }
}
