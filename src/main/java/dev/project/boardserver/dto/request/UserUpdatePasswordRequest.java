package dev.project.boardserver.dto.request;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdatePasswordRequest {
    @Nonnull
    private String beforePassword;
    @Nonnull
    private String afterPassword;
}
