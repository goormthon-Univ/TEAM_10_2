package Goormoa.goormoa_server.controller.user;


import Goormoa.goormoa_server.dto.recommend.RecommendFriendDTO;
import Goormoa.goormoa_server.dto.token.TokenDTO;
import Goormoa.goormoa_server.dto.user.UserDTO;
import Goormoa.goormoa_server.service.auth.AuthenticationService;
import Goormoa.goormoa_server.service.token.TokenService;
import Goormoa.goormoa_server.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationService authenticationService;
//    private final FriendRecommendationService friendRecommendationService;

    @PostMapping("/login") // 로그인
    public ResponseEntity<TokenDTO> login(@RequestBody UserDTO userDto) {
        TokenDTO jwt = userService.login(userDto);
        return jwt != null ?
                ResponseEntity.ok(jwt) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/signup") // 회원가입
    public ResponseEntity<String> signup(@RequestBody UserDTO userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PostMapping("/out") // 로그아웃
    public ResponseEntity<String> logout(HttpServletRequest request) {
        return ResponseEntity.ok(tokenService.logout(request.getHeader("Authorization")));
    }

    @PostMapping("/delete") // 회원탈퇴
    public ResponseEntity<String> delete() {
        String currentUserEmail = authenticationService.getCurrentAuthenticatedUserEmail();
        return ResponseEntity.ok(userService.delete(currentUserEmail));
    }


//    @GetMapping("/recommend") // 추천 친구
//    public ResponseEntity<List<RecommendFriendDTO>> recommend() {
//        String currentUserEmail = authenticationService.getCurrentAuthenticatedUserEmail();
//        return ResponseEntity.ok(friendRecommendationService.getRecommendFriendList(currentUserEmail));
//    }

    @GetMapping("/api/getUserEmail") // 회원 이메일 추출
    public ResponseEntity<String> getUserEmail() {
        String currentUserEmail = authenticationService.getCurrentAuthenticatedUserEmail();
        return ResponseEntity.ok(currentUserEmail);
    }
}
