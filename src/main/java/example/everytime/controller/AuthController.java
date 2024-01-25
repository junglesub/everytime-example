package example.everytime.controller;

import example.everytime.controller.form.SignInForm;
import example.everytime.controller.form.SignUpForm;
import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.MemberIdResponse;
import example.everytime.dto.MemberDto;
import example.everytime.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

  private final MemberService memberService;

  @PostMapping("/sign-up")
  public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpForm form) {
    Long memberId = memberService.addMember(MemberDto.from(form));
    ApiResponse response = new MemberIdResponse(memberId, true);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/sign-up/validation")
  public ResponseEntity<Long> validateId(@RequestParam String id) {
    return ResponseEntity.ok().build();
  }

  @PostMapping("/sign-in")
  public ResponseEntity<ApiResponse> signIn(@RequestBody SignInForm form) {
    Long memberId = memberService.signInMember(MemberDto.from(form));
    ApiResponse response = new MemberIdResponse(memberId, true);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/sign-out")
  public ResponseEntity<ApiResponse> signOut() {
    return ResponseEntity.ok(new ApiResponse(true));
  }
}
