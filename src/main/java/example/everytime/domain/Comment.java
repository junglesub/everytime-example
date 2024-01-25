package example.everytime.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Comment extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long commentId;

  private String content;
  private int likeCount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Post post;
}
