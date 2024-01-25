package example.everytime.controller.response;

import example.everytime.dto.PostDto;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListResponse extends ApiResponse {

  private List<PostDto> posts;
  private int count;

  public PostListResponse(boolean isSuccessful, List<PostDto> postsDto) {
    super(isSuccessful);
    this.posts = postsDto;
    this.count = postsDto.size();
  }
}
