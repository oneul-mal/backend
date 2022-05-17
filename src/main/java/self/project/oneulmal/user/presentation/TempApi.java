package self.project.oneulmal.user.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempApi {

    @GetMapping("/")
    public String index() {
        return "뭐 홈페이지 입니다?";
    }
}
