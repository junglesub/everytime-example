package example.everytime.exception;

public class PostNotFoundException extends RuntimeException {

  private static final String POST_NOT_FOUND = "게시글을 찾을 수 없습니다.";

  public PostNotFoundException() {
    super(POST_NOT_FOUND);
  }
}
