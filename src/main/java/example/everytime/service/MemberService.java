package example.everytime.service;

import example.everytime.domain.College;
import example.everytime.domain.Member;
import example.everytime.dto.MemberDto;
import example.everytime.exception.MemberNotFoundException;
import example.everytime.exception.UsernameAlreadyExistsException;
import example.everytime.repository.CollegeRepository;
import example.everytime.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final CollegeRepository collegeRepository;

  public Long addMember(MemberDto memberDto) {
    College college = collegeRepository.findCollegeByName(memberDto.getCollegeName());
    Member member = memberRepository.save(Member.toMember(memberDto, college));
    return member.getMemberId();
  }

  public Long signInMember(MemberDto memberDto) {
    Member member =
        memberRepository
            .findMemberByUsernameAndPassword(memberDto.getUsername(), memberDto.getPassword())
            .orElseThrow(MemberNotFoundException::new);
    return member.getMemberId();
  }

  public MemberDto getProfileOf(Long memberId) {
    System.out.println("memberId = " + memberId);
    Member member =
        memberRepository
            .findByIdWIthCollege(memberId)
            .orElseThrow(MemberNotFoundException::new);
    return MemberDto.from(member);
  }

  public void validateUsername(String username) {
    memberRepository
        .findByUsername(username)
        .ifPresent(
            (__) -> {
              throw new UsernameAlreadyExistsException();
            });
  }
}
