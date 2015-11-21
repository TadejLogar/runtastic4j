# Runtastic4J

Runtastic4J is a Java library to access activites and user details from a Runtastic Account. (www.runtastic.com)

This is __NOT__ an official API.

## Usage

Create a new instance of the Runtastic object.
You need to pass a HTML client to the Runtastic Constructor.
You have to create the HTTP client yourself by implementing RuntasticHttpClient.
The OkHttpRunClient example class uses the OkHttp Library.
```java
Runtastic runtastic = new Runtastic(new OkHttpRunClient());
```

Before you can access your details and activites you have to log in:
```java
boolean success = runtastic.login(USERNAME, PASSWORD);

```

Now you can get a List of all your Activites using:
```java
List<RuntasticActivity> activites = runtastic.getActivites();
```

Or you can access detailed information about  the user using:
```java
RuntasticUser user = runtastic.getUser()
```

### HttpClient example
```java
public class OkHttpRunClient implements RuntasticHttpClient {

    private OkHttpClient client;

    private static final int TIMEOUT = 15;

    @Override
    public void initialize() {
        client = new OkHttpClient();
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        client.setCookieHandler(cookieManager);
        client.setConnectTimeout(TIMEOUT, TimeUnit.SECONDS);
        client.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
    }

    @Override
    public RunResponse getResponse(String url, RequestMethod rm, @Nullable HashMap<String, String> postParams) throws IOException {

        RequestBody rb = null;

        if (postParams != null) {
            FormEncodingBuilder paramBuilder = new FormEncodingBuilder();

            for (Map.Entry<String, String> entry : postParams.entrySet()) {
                paramBuilder.add(entry.getKey(), entry.getValue());
            }

            rb = paramBuilder.build();
        }

        Request.Builder rqBuilder = new Request.Builder();

        rqBuilder.url(url);

        if (rm == null || rm == RequestMethod.GET) {
            rqBuilder.get();
        } else if (rm == RequestMethod.POST && rb != null) {
            rqBuilder.post(rb);
        } else {
            throw new IOException();
        }

        Request request = rqBuilder.build();

        Response response = client.newCall(request).execute();

        return new RunResponse(response.code(), response.body().string());
    }
```


License
--------
    Copyright 2015 Florian Nußmüller

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
