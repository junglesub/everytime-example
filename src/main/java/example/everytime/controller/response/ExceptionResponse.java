package example.everytime.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ExceptionResponse extends ApiResponse {

  private String message;

  public ExceptionResponse(boolean isSuccessful, String message) {
    super(isSuccessful);
    this.message = message;
  }
}
