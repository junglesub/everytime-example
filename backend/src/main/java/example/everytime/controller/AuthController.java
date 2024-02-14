package example.everytime.controller;

import example.everytime.controller.form.SignInForm;
import example.everytime.controller.form.SignUpForm;
import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.MemberIdResponse;
import example.everytime.dto.MemberDto;
import example.everytime.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/auth")
@RequiredArgsConstructor
public class AuthController {

  private final MemberService memberService;

  @PostMapping("/sign-up")
  public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpForm form) {
    Long memberId = memberService.addMember(MemberDto.from(form));
    ApiResponse response = new MemberIdResponse(memberId);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/sign-up/validation")
  public ResponseEntity<ApiResponse> validateId(@RequestParam String username) {
    memberService.validateUsername(username);
    return ResponseEntity.ok(new ApiResponse(true));
  }

  @PostMapping("/sign-in")
  public ResponseEntity<ApiResponse> signIn(@RequestBody SignInForm form, HttpSession session) {
    Long memberId = memberService.signInMember(MemberDto.from(form));
    session.setAttribute("memberId", memberId);
    ApiResponse response = new MemberIdResponse(memberId);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/sign-out")
  public ResponseEntity<ApiResponse> signOut(HttpSession session) {
    session.invalidate();
    return ResponseEntity.ok(new ApiResponse(true));
  }
}
