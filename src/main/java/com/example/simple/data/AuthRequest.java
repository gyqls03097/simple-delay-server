package com.example.simple.data;

import lombok.Data;

@Data
public class AuthRequest {

  private String packageName;
  private String customer;
  private String appSign;
}
