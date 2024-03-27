package dev.project.boardserver.dto.request;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDeleteId {
    @Nonnull
    private String id;
    @Nonnull
    private String password;
}
