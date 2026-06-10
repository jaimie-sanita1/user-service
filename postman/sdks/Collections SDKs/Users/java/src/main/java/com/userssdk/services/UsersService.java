package com.userssdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.userssdk.config.RequestConfig;
import com.userssdk.config.UsersSdkConfig;
import com.userssdk.exceptions.ApiError;
import com.userssdk.http.Environment;
import com.userssdk.http.HttpMethod;
import com.userssdk.http.ModelConverter;
import com.userssdk.http.util.RequestBuilder;
import com.userssdk.models.CreateAUserParameters;
import com.userssdk.models.ListAllUsersParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * UsersService Service
 */
public class UsersService extends BaseService {

  private RequestConfig listAllUsersConfig = RequestConfig.builder()
    .environment(Environment.HTTPS)
    .build();
  private RequestConfig createAUserConfig = RequestConfig.builder()
    .environment(Environment.HTTPS)
    .build();

  /**
   * Constructs a new instance of UsersService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public UsersService(@NonNull OkHttpClient httpClient, UsersSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listAllUsers}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public UsersService setListAllUsersConfig(RequestConfig config) {
    this.listAllUsersConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createAUser}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public UsersService setCreateAUserConfig(RequestConfig config) {
    this.createAUserConfig = config;
    return this;
  }

  /**
   * Method listAllUsers
   * GET /users
   *
   * @param requestParameters {@link ListAllUsersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listAllUsers(@NonNull ListAllUsersParameters requestParameters) throws ApiError {
    return this.listAllUsers(requestParameters, null);
  }

  /**
   * Method listAllUsers
   * GET /users
   *
   * @param requestParameters {@link ListAllUsersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listAllUsers(
    @NonNull ListAllUsersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listAllUsersConfig, requestConfig);
    Request request = this.buildListAllUsersRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method listAllUsers
   * GET /users
   *
   * @param requestParameters {@link ListAllUsersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllUsersAsync(
    @NonNull ListAllUsersParameters requestParameters
  ) throws ApiError {
    return this.listAllUsersAsync(requestParameters, null);
  }

  /**
   * Method listAllUsers
   * GET /users
   *
   * @param requestParameters {@link ListAllUsersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllUsersAsync(
    @NonNull ListAllUsersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listAllUsersConfig, requestConfig);
    Request request = this.buildListAllUsersRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListAllUsersRequest(
    @NonNull ListAllUsersParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.HTTPS),
      "users"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }

  /**
   * Method createAUser
   * POST /users
   *
   * @param requestParameters {@link CreateAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createAUser(@NonNull CreateAUserParameters requestParameters) throws ApiError {
    return this.createAUser(requestParameters, null);
  }

  /**
   * Method createAUser
   * POST /users
   *
   * @param requestParameters {@link CreateAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createAUser(
    @NonNull CreateAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createAUserConfig, requestConfig);
    Request request = this.buildCreateAUserRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method createAUser
   * POST /users
   *
   * @param requestParameters {@link CreateAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAUserAsync(
    @NonNull CreateAUserParameters requestParameters
  ) throws ApiError {
    return this.createAUserAsync(requestParameters, null);
  }

  /**
   * Method createAUser
   * POST /users
   *
   * @param requestParameters {@link CreateAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAUserAsync(
    @NonNull CreateAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createAUserConfig, requestConfig);
    Request request = this.buildCreateAUserRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateAUserRequest(
    @NonNull CreateAUserParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.HTTPS),
      "users"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
