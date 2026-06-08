# UsersSdk Java SDK 1.0.0

Welcome to the UsersSdk SDK documentation. This guide will help you get started with integrating and using the UsersSdk SDK in your project.

## Versions

- SDK version: `1.0.0`

## About the API

A simple API for managing users

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com</groupId>
    <artifactId>userssdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation("com:userssdk:1.0.0")
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.userssdk.UsersSdk;
import com.userssdk.config.UsersSdkConfig;

public class Main {

  public static void main(String[] args) {
    UsersSdkConfig config = UsersSdkConfig.builder().timeout(10000).build();
    UsersSdk usersSdk = new UsersSdk(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
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

```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                   |
| :----------------------------------------------------- |
| [IdService](documentation/services/IdService.md)       |
| [UsersService](documentation/services/UsersService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                                                   | Description |
| :--------------------------------------------------------------------------------------------------------------------- | :---------- |
| [GetAUserByIdParameters](documentation/models/GetAUserByIdParameters.md)                                               |             |
| [UpdateAUserRequest](documentation/models/UpdateAUserRequest.md)                                                       |             |
| [UpdateAUserParameters](documentation/models/UpdateAUserParameters.md)                                                 |             |
| [DeleteAUserParameters](documentation/models/DeleteAUserParameters.md)                                                 |             |
| [AShortSummaryOfWhatTheOperationDoesParameters](documentation/models/AShortSummaryOfWhatTheOperationDoesParameters.md) |             |
| [ListAllUsersParameters](documentation/models/ListAllUsersParameters.md)                                               |             |
| [CreateAUserRequest](documentation/models/CreateAUserRequest.md)                                                       |             |
| [CreateAUserParameters](documentation/models/CreateAUserParameters.md)                                                 |             |

</details>
