package example.everytime.controller;

import example.everytime.controller.form.PostForm;
import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.PostIdResponse;
import example.everytime.controller.response.PostListResponse;
import example.everytime.controller.response.PostResponse;
import example.everytime.dto.PostDto;
import example.everytime.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/posts")
public class PostController {

  private final PostService postService;

  @PostMapping
  public ResponseEntity<ApiResponse> addPost(
      @SessionAttribute Long memberId, @RequestBody PostForm form) {
    Long postId = postService.addPost(PostDto.from(memberId, form));
    ApiResponse response = new PostIdResponse(postId);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<ApiResponse> getAllPosts(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
    long count = postService.countAllPosts();
    List<PostDto> postsDto = postService.getAllPosts(page, size);
    ApiResponse response = new PostListResponse(postsDto, count);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<ApiResponse> getPost(@PathVariable Long postId) {
    PostDto post = postService.getPost(postId);
    ApiResponse response = new PostResponse(post);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId) {
    postService.deletePost(postId);
    ApiResponse response = new PostIdResponse(postId);
    return ResponseEntity.ok(response);
  }
}
