package example.everytime.dto;

import example.everytime.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

  private Long commentId;

  private String content;

  private int likeCount;

  public CommentDto from(Comment comment) {
    return CommentDto.builder()
        .commentId(comment.getCommentId())
        .content(comment.getContent())
        .likeCount(comment.getLikeCount())
        .build();
  }
}
