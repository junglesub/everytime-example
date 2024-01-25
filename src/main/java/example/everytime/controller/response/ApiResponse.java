package example.everytime.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ApiResponse {
  public boolean isSuccessful;

  public ApiResponse(boolean isSuccessful) {
    this.isSuccessful = isSuccessful;
  }
}
