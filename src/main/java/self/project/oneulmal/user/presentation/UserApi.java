package self.project.oneulmal.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import self.project.oneulmal.user.application.UserService;
import self.project.oneulmal.user.presentation.dto.UserRegisterReq;
import self.project.oneulmal.user.presentation.dto.UserRegisterRes;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<UserRegisterRes> register(@RequestBody UserRegisterReq userRegisterReq) {
        UserRegisterRes userRegisterRes = userService.save(userRegisterReq);
        return ResponseEntity.ok(userRegisterRes);
    }

}
