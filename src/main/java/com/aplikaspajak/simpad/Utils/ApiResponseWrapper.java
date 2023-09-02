package com.aplikaspajak.simpad.Utils;

public class ApiResponseWrapper<T> {

  private T data;
  private String status;
  private String message;

  public ApiResponseWrapper(T data, String status, String message) {
    this.data = data;
    this.status = status;
    this.message = message;
  }
  // Getters and setters for data, status, and message
}
