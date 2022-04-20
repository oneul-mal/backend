package self.project.oneulmal.user.presentation.dto;

public class UserAssembler {
    public static UserRegisterRes userRegisterRes(UserRegisterReq userRegisterReq) {
        return UserRegisterRes.builder()
                .name(userRegisterReq.getName())
                .build();
    }
}
