# UsersService

A list of all methods in the `UsersService` service. Click on the method name to view detailed information about that method.

| Methods                       | Description |
| :---------------------------- | :---------- |
| [listAllUsers](#listallusers) |             |
| [createAUser](#createauser)   |             |

## listAllUsers

- HTTP Method: `GET`
- Endpoint: `/users`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListAllUsersParameters](../models/ListAllUsersParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.ListAllUsersParameters;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    ListAllUsersParameters requestParameters = ListAllUsersParameters.builder()
      .accept("application/json")
      .build();

    Object response = usersSdk.users.listAllUsers(requestParameters);

    System.out.println(response);
  }
}

```

## createAUser

- HTTP Method: `POST`
- Endpoint: `/users`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateAUserParameters](../models/CreateAUserParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.CreateAUserParameters;
import com.userssdk.models.CreateAUserRequest;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    CreateAUserRequest createAUserRequest = CreateAUserRequest.builder()
      .name("John Doe")
      .email("john.doe@example.com")
      .role("member")
      .status("active")
      .build();

    CreateAUserParameters requestParameters = CreateAUserParameters.builder()
      .accept("application/json")
      .requestBody(createAUserRequest)
      .build();

    Object response = usersSdk.users.createAUser(requestParameters);

    System.out.println(response);
  }
}

```
