package example.everytime.dto;

import example.everytime.controller.form.PostForm;
import example.everytime.domain.Post;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

  private Long postId;
  private Long memberId;
  private String title;
  private String content;
  private boolean isAnonymous;
  private int likeCount;
  private String nickname;
  private LocalDateTime createdDate;

  public static PostDto from(Post post) {
    return PostDto.builder()
        .postId(post.getPostId())
        .memberId(post.getMember().getMemberId())
        .title(post.getTitle())
        .content(post.getContent())
        .isAnonymous(post.getIsAnonymous())
        .likeCount(post.getLikeCount())
        .nickname(post.getMember().getNickname())
        .createdDate(post.getCreatedDate())
        .build();
  }

  public static PostDto from(Long memberId, PostForm postForm) {
    return PostDto.builder()
        .memberId(memberId)
        .title(postForm.getTitle())
        .content(postForm.getContent())
        .isAnonymous(postForm.getIsAnonymous())
        .build();
  }
}
