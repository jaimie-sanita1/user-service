package com.userssdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateAUserRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("email")
  private JsonNullable<String> email;

  @JsonProperty("role")
  private JsonNullable<String> role;

  @JsonProperty("status")
  private JsonNullable<String> status;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getRole() {
    return role.orElse(null);
  }

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UpdateAUserRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public UpdateAUserRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public UpdateAUserRequestBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> role = JsonNullable.undefined();

    @JsonProperty("role")
    public UpdateAUserRequestBuilder role(String value) {
      this.role = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public UpdateAUserRequestBuilder status(String value) {
      this.status = JsonNullable.of(value);
      return this;
    }
  }
}
