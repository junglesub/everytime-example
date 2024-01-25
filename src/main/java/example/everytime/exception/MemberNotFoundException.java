package example.everytime.exception;

public class MemberNotFoundException extends RuntimeException {

  private static final String MEMBER_NOT_FOUND = "회원을 찾을 수 없습니다.";

  public MemberNotFoundException() {
    super(MEMBER_NOT_FOUND);
  }
}
