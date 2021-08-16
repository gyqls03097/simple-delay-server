package com.example.simple.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlCheckData {

  private Long tm;
  private String url;
  private String blockType;
  private String provider;
  private String redirectUrl;
}
    
