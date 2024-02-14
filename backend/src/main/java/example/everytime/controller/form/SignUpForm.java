package example.everytime.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpForm {

  private String username;

  private String password;

  private String email;

  private String nickname;

  private int entranceYear;

  private String collegeName;
}
