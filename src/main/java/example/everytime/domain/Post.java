package example.everytime.domain;

import example.everytime.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;

  private String title;
  private String content;
  private Boolean isAnonymous;
  private int likeCount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private Board board;

  public static Post toPost(PostDto postDto, Member member) {
    return Post.builder()
        .title(postDto.getTitle())
        .content(postDto.getContent())
        .isAnonymous(postDto.isAnonymous())
        .member(member)
        .build();
  }
}
