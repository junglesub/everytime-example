package example.everytime.domain;

import example.everytime.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  private String username;
  private String password;
  private String email;
  private String nickname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "college_id")
  private College college;

  public static Member toMember(MemberDto memberDto, College college) {
    return Member.builder()
        .username(memberDto.getUsername())
        .password(memberDto.getPassword())
        .email(memberDto.getEmail())
        .nickname(memberDto.getNickname())
        .college(college)
        .build();
  }
}
