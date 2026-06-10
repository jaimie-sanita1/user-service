package com.example;

import com.userssdk.UsersSdk;
import com.userssdk.exceptions.ApiError;
import com.userssdk.models.ListAllUsersParameters;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    ListAllUsersParameters requestParameters = ListAllUsersParameters.builder()
      .accept("application/json")
      .build();

    try {
      Object response = usersSdk.users.listAllUsers(requestParameters);

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
