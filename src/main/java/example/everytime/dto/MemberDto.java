package example.everytime.dto;

import example.everytime.controller.form.SignInForm;
import example.everytime.controller.form.SignUpForm;
import example.everytime.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

  private Long memberId;

  private String password;

  private String username;

  private String email;

  private String nickname;

  private int entranceYear;

  private String collegeName;

  public static MemberDto from(Member member) {
    return MemberDto.builder()
        .memberId(member.getMemberId())
        .password(member.getPassword())
        .username(member.getUsername())
        .email(member.getEmail())
        .nickname(member.getNickname())
        .collegeName(member.getCollege().getName())
        .build();
  }

  public static MemberDto from(SignUpForm signUpForm) {
    return MemberDto.builder()
        .username(signUpForm.getUsername())
        .password(signUpForm.getPassword())
        .email(signUpForm.getEmail())
        .nickname(signUpForm.getNickname())
        .entranceYear(signUpForm.getEntranceYear())
        .collegeName(signUpForm.getCollegeName())
        .build();
  }

  public static MemberDto from(SignInForm signInForm) {
    return MemberDto.builder()
        .username(signInForm.getUsername())
        .password(signInForm.getPassword())
        .build();
  }
}
