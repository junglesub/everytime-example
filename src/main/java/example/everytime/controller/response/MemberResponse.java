package example.everytime.controller.response;

import example.everytime.dto.MemberDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse extends ApiResponse {

  private String username;
  private String nickname;
  private String collegeName;

  public MemberResponse(boolean isSuccessful, MemberDto memberDto) {
    super(isSuccessful);
    this.username = memberDto.getUsername();
    this.nickname = memberDto.getNickname();
    this.collegeName = memberDto.getCollegeName();
  }
}
