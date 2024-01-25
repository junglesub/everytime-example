package example.everytime.controller;

import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.MemberResponse;
import example.everytime.dto.MemberDto;
import example.everytime.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/profile/{memberId}")
  public ResponseEntity<ApiResponse> getProfile(@PathVariable Long memberId) {
    MemberDto memberDto = memberService.getProfileOf(memberId);
    ApiResponse response = new MemberResponse(true, memberDto);
    return ResponseEntity.ok(response);
  }
}
