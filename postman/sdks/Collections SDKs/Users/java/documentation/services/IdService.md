# IdService

A list of all methods in the `IdService` service. Click on the method name to view detailed information about that method.

| Methods                                                                     | Description |
| :-------------------------------------------------------------------------- | :---------- |
| [getAUserById](#getauserbyid)                                               |             |
| [updateAUser](#updateauser)                                                 |             |
| [deleteAUser](#deleteauser)                                                 |             |
| [aShortSummaryOfWhatTheOperationDoes](#ashortsummaryofwhattheoperationdoes) |             |

## getAUserById

- HTTP Method: `GET`
- Endpoint: `/users/{id}`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| id                | String                                                        | ✅       |                           |
| requestParameters | [GetAUserByIdParameters](../models/GetAUserByIdParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.GetAUserByIdParameters;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    GetAUserByIdParameters requestParameters = GetAUserByIdParameters.builder()
      .accept("application/json")
      .build();

    Object response = usersSdk.id.getAUserById("id", requestParameters);

    System.out.println(response);
  }
}

```

## updateAUser

- HTTP Method: `PUT`
- Endpoint: `/users/{id}`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| id                | String                                                      | ✅       |                           |
| requestParameters | [UpdateAUserParameters](../models/UpdateAUserParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.UpdateAUserParameters;
import com.userssdk.models.UpdateAUserRequest;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    UpdateAUserRequest updateAUserRequest = UpdateAUserRequest.builder()
      .name("Jane Smith")
      .email("jane.smith@example.com")
      .role("admin")
      .status("active")
      .build();

    UpdateAUserParameters requestParameters = UpdateAUserParameters.builder()
      .accept("application/json")
      .requestBody(updateAUserRequest)
      .build();

    Object response = usersSdk.id.updateAUser("id", requestParameters);

    System.out.println(response);
  }
}

```

## deleteAUser

- HTTP Method: `DELETE`
- Endpoint: `/users/{id}`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| id                | String                                                      | ✅       |                           |
| requestParameters | [DeleteAUserParameters](../models/DeleteAUserParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.DeleteAUserParameters;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    DeleteAUserParameters requestParameters = DeleteAUserParameters.builder()
      .accept("application/json")
      .build();

    Object response = usersSdk.id.deleteAUser("id", requestParameters);

    System.out.println(response);
  }
}

```

## aShortSummaryOfWhatTheOperationDoes

- HTTP Method: `POST`
- Endpoint: `/users/{id}`

**Parameters**

| Name              | Type                                                                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| id                | String                                                                                                      | ✅       |                           |
| requestParameters | [AShortSummaryOfWhatTheOperationDoesParameters](../models/AShortSummaryOfWhatTheOperationDoesParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.userssdk.UsersSdk;
import com.userssdk.models.AShortSummaryOfWhatTheOperationDoesParameters;

public class Main {

  public static void main(String[] args) {
    UsersSdk usersSdk = new UsersSdk();

    AShortSummaryOfWhatTheOperationDoesParameters requestParameters =
      AShortSummaryOfWhatTheOperationDoesParameters.builder().accept("application/json").build();

    Object response = usersSdk.id.aShortSummaryOfWhatTheOperationDoes("id", requestParameters);

    System.out.println(response);
  }
}

```
