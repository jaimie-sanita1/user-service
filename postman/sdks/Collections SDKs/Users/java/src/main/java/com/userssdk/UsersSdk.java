package com.userssdk;

import com.userssdk.config.UsersSdkConfig;
import com.userssdk.http.Environment;
import com.userssdk.http.interceptors.DefaultHeadersInterceptor;
import com.userssdk.http.interceptors.RetryInterceptor;
import com.userssdk.services.IdService;
import com.userssdk.services.UsersService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** A simple API for managing users */
public class UsersSdk {

  public final IdService id;
  public final UsersService users;

  private final UsersSdkConfig config;

  /**
   * Constructs a new instance of UsersSdk with default configuration.
   */
  public UsersSdk() {
    // Default configs
    this(UsersSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of UsersSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public UsersSdk(UsersSdkConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.id = new IdService(httpClient, config);
    this.users = new UsersService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
