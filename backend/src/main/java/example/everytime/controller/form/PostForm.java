package example.everytime.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostForm {
  //  private Long memberId;
  private String title;
  private String content;
  private Boolean isAnonymous;
}
