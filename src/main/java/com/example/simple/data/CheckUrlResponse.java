package com.example.simple.data;

import java.util.List;
import lombok.Data;

@Data
public class CheckUrlResponse {

  private List<UrlCheckData> result;
}
