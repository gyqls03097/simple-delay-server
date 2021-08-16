package com.example.simple.data;

import java.util.List;
import lombok.Data;

@Data
public class CheckUrlRequest {

  private List<String> urls;
}
