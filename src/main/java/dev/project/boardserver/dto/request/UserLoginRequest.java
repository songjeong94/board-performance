package dev.project.boardserver.dto.request;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {
    @Nonnull
    private String userId;
    @Nonnull
    private String password;
}
