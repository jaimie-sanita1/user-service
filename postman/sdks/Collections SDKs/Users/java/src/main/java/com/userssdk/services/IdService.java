package com.userssdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.userssdk.config.RequestConfig;
import com.userssdk.config.UsersSdkConfig;
import com.userssdk.exceptions.ApiError;
import com.userssdk.http.Environment;
import com.userssdk.http.HttpMethod;
import com.userssdk.http.ModelConverter;
import com.userssdk.http.util.RequestBuilder;
import com.userssdk.models.AShortSummaryOfWhatTheOperationDoesParameters;
import com.userssdk.models.DeleteAUserParameters;
import com.userssdk.models.GetAUserByIdParameters;
import com.userssdk.models.UpdateAUserParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IdService Service
 */
public class IdService extends BaseService {

  private RequestConfig getAUserByIdConfig = RequestConfig.builder()
    .environment(Environment.SERVER)
    .build();
  private RequestConfig updateAUserConfig = RequestConfig.builder()
    .environment(Environment.SERVER)
    .build();
  private RequestConfig deleteAUserConfig = RequestConfig.builder()
    .environment(Environment.SERVER)
    .build();
  private RequestConfig aShortSummaryOfWhatTheOperationDoesConfig = RequestConfig.builder()
    .environment(Environment.SERVER)
    .build();

  /**
   * Constructs a new instance of IdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public IdService(@NonNull OkHttpClient httpClient, UsersSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getAUserById}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public IdService setGetAUserByIdConfig(RequestConfig config) {
    this.getAUserByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateAUser}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public IdService setUpdateAUserConfig(RequestConfig config) {
    this.updateAUserConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteAUser}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public IdService setDeleteAUserConfig(RequestConfig config) {
    this.deleteAUserConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code aShortSummaryOfWhatTheOperationDoes}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public IdService setAShortSummaryOfWhatTheOperationDoesConfig(RequestConfig config) {
    this.aShortSummaryOfWhatTheOperationDoesConfig = config;
    return this;
  }

  /**
   * Method getAUserById
   * GET /users/{id}
   *
   * @param id String
   * @param requestParameters {@link GetAUserByIdParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getAUserById(@NonNull String id, @NonNull GetAUserByIdParameters requestParameters)
    throws ApiError {
    return this.getAUserById(id, requestParameters, null);
  }

  /**
   * Method getAUserById
   * GET /users/{id}
   *
   * @param id String
   * @param requestParameters {@link GetAUserByIdParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getAUserById(
    @NonNull String id,
    @NonNull GetAUserByIdParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getAUserByIdConfig, requestConfig);
    Request request = this.buildGetAUserByIdRequest(id, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method getAUserById
   * GET /users/{id}
   *
   * @param id String
   * @param requestParameters {@link GetAUserByIdParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAUserByIdAsync(
    @NonNull String id,
    @NonNull GetAUserByIdParameters requestParameters
  ) throws ApiError {
    return this.getAUserByIdAsync(id, requestParameters, null);
  }

  /**
   * Method getAUserById
   * GET /users/{id}
   *
   * @param id String
   * @param requestParameters {@link GetAUserByIdParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAUserByIdAsync(
    @NonNull String id,
    @NonNull GetAUserByIdParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getAUserByIdConfig, requestConfig);
    Request request = this.buildGetAUserByIdRequest(id, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetAUserByIdRequest(
    @NonNull String id,
    @NonNull GetAUserByIdParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.SERVER),
      "users/{id}"
    )
      .setPathParameter("id", id)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }

  /**
   * Method updateAUser
   * PUT /users/{id}
   *
   * @param id String
   * @param requestParameters {@link UpdateAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object updateAUser(@NonNull String id, @NonNull UpdateAUserParameters requestParameters)
    throws ApiError {
    return this.updateAUser(id, requestParameters, null);
  }

  /**
   * Method updateAUser
   * PUT /users/{id}
   *
   * @param id String
   * @param requestParameters {@link UpdateAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object updateAUser(
    @NonNull String id,
    @NonNull UpdateAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.updateAUserConfig, requestConfig);
    Request request = this.buildUpdateAUserRequest(id, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method updateAUser
   * PUT /users/{id}
   *
   * @param id String
   * @param requestParameters {@link UpdateAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateAUserAsync(
    @NonNull String id,
    @NonNull UpdateAUserParameters requestParameters
  ) throws ApiError {
    return this.updateAUserAsync(id, requestParameters, null);
  }

  /**
   * Method updateAUser
   * PUT /users/{id}
   *
   * @param id String
   * @param requestParameters {@link UpdateAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateAUserAsync(
    @NonNull String id,
    @NonNull UpdateAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.updateAUserConfig, requestConfig);
    Request request = this.buildUpdateAUserRequest(id, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildUpdateAUserRequest(
    @NonNull String id,
    @NonNull UpdateAUserParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.SERVER),
      "users/{id}"
    )
      .setPathParameter("id", id)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Method deleteAUser
   * DELETE /users/{id}
   *
   * @param id String
   * @param requestParameters {@link DeleteAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object deleteAUser(@NonNull String id, @NonNull DeleteAUserParameters requestParameters)
    throws ApiError {
    return this.deleteAUser(id, requestParameters, null);
  }

  /**
   * Method deleteAUser
   * DELETE /users/{id}
   *
   * @param id String
   * @param requestParameters {@link DeleteAUserParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object deleteAUser(
    @NonNull String id,
    @NonNull DeleteAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteAUserConfig, requestConfig);
    Request request = this.buildDeleteAUserRequest(id, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method deleteAUser
   * DELETE /users/{id}
   *
   * @param id String
   * @param requestParameters {@link DeleteAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteAUserAsync(
    @NonNull String id,
    @NonNull DeleteAUserParameters requestParameters
  ) throws ApiError {
    return this.deleteAUserAsync(id, requestParameters, null);
  }

  /**
   * Method deleteAUser
   * DELETE /users/{id}
   *
   * @param id String
   * @param requestParameters {@link DeleteAUserParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteAUserAsync(
    @NonNull String id,
    @NonNull DeleteAUserParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteAUserConfig, requestConfig);
    Request request = this.buildDeleteAUserRequest(id, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteAUserRequest(
    @NonNull String id,
    @NonNull DeleteAUserParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.SERVER),
      "users/{id}"
    )
      .setPathParameter("id", id)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }

  /**
   * Method aShortSummaryOfWhatTheOperationDoes
   * POST /users/{id}
   *
   * @param id String
   * @param requestParameters {@link AShortSummaryOfWhatTheOperationDoesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object aShortSummaryOfWhatTheOperationDoes(
    @NonNull String id,
    @NonNull AShortSummaryOfWhatTheOperationDoesParameters requestParameters
  ) throws ApiError {
    return this.aShortSummaryOfWhatTheOperationDoes(id, requestParameters, null);
  }

  /**
   * Method aShortSummaryOfWhatTheOperationDoes
   * POST /users/{id}
   *
   * @param id String
   * @param requestParameters {@link AShortSummaryOfWhatTheOperationDoesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object aShortSummaryOfWhatTheOperationDoes(
    @NonNull String id,
    @NonNull AShortSummaryOfWhatTheOperationDoesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.aShortSummaryOfWhatTheOperationDoesConfig, requestConfig);
    Request request =
      this.buildAShortSummaryOfWhatTheOperationDoesRequest(id, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method aShortSummaryOfWhatTheOperationDoes
   * POST /users/{id}
   *
   * @param id String
   * @param requestParameters {@link AShortSummaryOfWhatTheOperationDoesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> aShortSummaryOfWhatTheOperationDoesAsync(
    @NonNull String id,
    @NonNull AShortSummaryOfWhatTheOperationDoesParameters requestParameters
  ) throws ApiError {
    return this.aShortSummaryOfWhatTheOperationDoesAsync(id, requestParameters, null);
  }

  /**
   * Method aShortSummaryOfWhatTheOperationDoes
   * POST /users/{id}
   *
   * @param id String
   * @param requestParameters {@link AShortSummaryOfWhatTheOperationDoesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> aShortSummaryOfWhatTheOperationDoesAsync(
    @NonNull String id,
    @NonNull AShortSummaryOfWhatTheOperationDoesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.aShortSummaryOfWhatTheOperationDoesConfig, requestConfig);
    Request request =
      this.buildAShortSummaryOfWhatTheOperationDoesRequest(id, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAShortSummaryOfWhatTheOperationDoesRequest(
    @NonNull String id,
    @NonNull AShortSummaryOfWhatTheOperationDoesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.SERVER),
      "users/{id}"
    )
      .setPathParameter("id", id)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
