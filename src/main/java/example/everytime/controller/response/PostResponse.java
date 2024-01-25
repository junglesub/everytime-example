package example.everytime.controller.response;

import example.everytime.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostResponse extends ApiResponse {

  private Long postId;
  private String title;
  private String content;
  private String nickname;
  private Boolean isAnonymous;
  private int likeCount;

  public PostResponse(PostDto post) {
    this.postId = post.getPostId();
    this.title = post.getTitle();
    this.content = post.getContent();
    this.nickname = post.getNickname();
    this.isAnonymous = post.isAnonymous();
    this.likeCount = post.getLikeCount();
  }
}
