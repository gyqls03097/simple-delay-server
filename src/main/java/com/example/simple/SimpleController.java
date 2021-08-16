package com.example.simple;

import com.example.simple.data.AuthRequest;
import com.example.simple.data.AuthResponse;
import com.example.simple.data.BlockURLType;
import com.example.simple.data.CheckUrlRequest;
import com.example.simple.data.CheckUrlResponse;
import com.example.simple.data.UrlCheckData;
import com.example.simple.data.WhiteUrlResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

  private static final String ADDRESS_NAVER = "https://m.naver.com/";

  @PostMapping("/api/v1/authorization")
  public ResponseEntity<AuthResponse> authorization(@RequestBody AuthRequest request) {

    AuthResponse body = new AuthResponse();
    body.setResult("0000");
    body.setSucceed(true);
    return ResponseEntity.ok(body);
  }

  @PostMapping("/api/v1/urlCheck")
  public ResponseEntity<CheckUrlResponse> checkUrl(@RequestBody CheckUrlRequest request) {

    List<String> urls = request.getUrls();
    if (!urls.isEmpty()) {
      System.out.println("url : " + urls.get(0));
    }

    CheckUrlResponse body = new CheckUrlResponse();
    if (urls.isEmpty() || !urls.get(0).startsWith(ADDRESS_NAVER)) {
      body.setResult(new ArrayList<>());
    } else {
      body.setResult(urls.stream()
          .map(url -> UrlCheckData.builder()
              .tm(System.currentTimeMillis())
              .url(url)
              .blockType(runDiceBlockUrlType().name())
              .redirectUrl("https://v3sc.ahnlab.co.jp/ext/webBlock")
              .provider("simple-server")
              .build())
          .collect(Collectors.toList()));
    }

    return ResponseEntity.ok(body);
  }

  @GetMapping("/api/v1/whiteList")
  public ResponseEntity<WhiteUrlResponse> getWhiteList() {

    WhiteUrlResponse body = new WhiteUrlResponse();
    body.setUrls(new ArrayList<>());
    return ResponseEntity.ok(body);
  }

  private BlockURLType runDiceBlockUrlType() {
    switch ((int) (System.currentTimeMillis() % 4)) {
      case 0:
        return BlockURLType.NONE;
      case 1:
        return BlockURLType.MALICIOUS;
      case 2:
        return BlockURLType.PHISHING;
      default:
        return BlockURLType.UNKNOWN;
    }
  }
}
