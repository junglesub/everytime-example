package example.everytime.controller.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostIdResponse extends ApiResponse {

  private Long postId;

  public PostIdResponse(boolean isSuccessful, Long postId) {
    super(isSuccessful);
    this.postId = postId;
  }
}
