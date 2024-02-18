package example.everytime.controller.response;

import example.everytime.dto.PostDto;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostListResponse extends ApiResponse {

  private List<PostDto> posts;
  private long count;

  public PostListResponse(List<PostDto> postDto, long count) {
    this.posts = postDto;
    this.count = count;
  }
}
