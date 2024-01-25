package example.everytime.controller.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse {
  public boolean isSuccessful;

  public ApiResponse(boolean isSuccessful) {
    this.isSuccessful = isSuccessful;
  }
}
