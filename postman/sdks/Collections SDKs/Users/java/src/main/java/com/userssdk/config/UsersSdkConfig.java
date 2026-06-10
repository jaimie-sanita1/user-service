package com.userssdk.config;

import com.userssdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

/**
 * Configuration class for SDK client settings.
 * Provides builder pattern for configuring base URLs, authentication, timeouts, and retry behavior.
 * All configuration options have sensible defaults and can be customized as needed.
 */
@Builder
@Data
public class UsersSdkConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "postman-codegen/1.1.2 userssdk/1.0.0 (java)";

  @Setter
  private String baseUrl;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;

  public void setEnvironment(Environment environment) {
    this.baseUrl = environment.getUrl();
  }
}
