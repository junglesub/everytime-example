package example.everytime.controller;

import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.MemberResponse;
import example.everytime.dto.MemberDto;
import example.everytime.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/profile/my")
  public ResponseEntity<ApiResponse> getProfile(@SessionAttribute Long memberId) {
    MemberDto memberDto = memberService.getProfileOf(memberId);
    ApiResponse response = new MemberResponse(memberDto);
    return ResponseEntity.ok(response);
  }
}
