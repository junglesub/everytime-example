package example.everytime.controller;

import example.everytime.controller.response.ApiResponse;
import example.everytime.controller.response.ExceptionResponse;
import example.everytime.exception.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(UsernameAlreadyExistsException.class)
  public ResponseEntity<ApiResponse> handleUsernameAlreadyExistsException(
      UsernameAlreadyExistsException e) {
    ApiResponse response =
        ExceptionResponse.builder()
            .isSuccessful(false)
            .error(HttpStatus.CONFLICT.getReasonPhrase())
            .message(e.getMessage())
            .build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }
}
