package example.everytime.controller.response;

import example.everytime.dto.PostDto;

public class PostResponse extends ApiResponse {

  private Long postId;
  private String title;
  private String content;
  private String username;
  private Boolean isAnonymous;
  private int likeCount;

  public PostResponse(boolean isSuccessful, PostDto post) {
    super(isSuccessful);
  }
}
