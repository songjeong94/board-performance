package dev.project.boardserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    public enum Status {
        DEFAULT, ADMIN, DELETED
    }

    private int id;
    private String userId;
    private String password;
    private String nickName;
    private boolean isAdmin;
    private Date createTime;
    private boolean isWithDraw;
    private Status status;
    private Date updateTime;

    public UserDTO(String id, String password, String name, String phone, String address, Status status, Date createTime, Date updateTime, boolean isAdmin) {
        this.userId = id;
        this.password = password;
        this.nickName = name;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isAdmin = isAdmin;
    }
    public static boolean hasNullDataBeforeRegister(UserDTO userDto) {
        return userDto.getUserId() == null || userDto.getPassword() == null || userDto.getNickName() == null;
    }
}
