package org.example.codingtest.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class JoinDTO {
        private Long id;

        public JoinDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class UpdateDTO {
        private Long id;
        private String name;

        public UpdateDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    @Data
    public static class GetUserDTO {
        private Long id;
        private String name;

        public GetUserDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
