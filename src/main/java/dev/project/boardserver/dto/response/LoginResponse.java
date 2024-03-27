package dev.project.boardserver.dto.response;

import dev.project.boardserver.dto.UserDTO;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginResponse {
    enum LoginStatus {
        SUCCESS, FAIL, DELETED
    }

    @Nonnull
    private LoginStatus result;
    private UserDTO userDto;

    private static final LoginResponse FAIL = new LoginResponse(LoginStatus.FAIL, null);

    public static LoginResponse success(UserDTO userDto) {
        return new LoginResponse(LoginStatus.SUCCESS, userDto);
    }
}
