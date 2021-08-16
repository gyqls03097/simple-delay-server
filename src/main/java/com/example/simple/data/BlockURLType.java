package com.example.simple.data;

public enum BlockURLType {
  PHISHING,
  MALICIOUS,
  UNKNOWN,
  NONE;

  public static BlockURLType of(String str) {
    for (BlockURLType value : values()) {
      if (value.name().equals(str)) {
        return value;
      }
    }
    return UNKNOWN;
  }
}
