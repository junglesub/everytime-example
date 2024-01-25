package example.everytime.controller.response;

import example.everytime.dto.MemberDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse extends ApiResponse {

  private Long memberId;
  private String nickname;
  private String collegeName;

  public MemberResponse(boolean isSuccessful, MemberDto memberDto) {
    super(isSuccessful);
    this.memberId = memberDto.getMemberId();
    this.nickname = memberDto.getNickname();
    this.collegeName = memberDto.getCollegeName();
  }
}
