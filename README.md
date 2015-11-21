# Runtastic4J

Runtastic4J is a Java library to access activites and user details from a Runtastic Account.

This is __NOT__ an official API.

## Usage

Create a new instance of the Runtastic object.
You need to pass a HTML client to the Runtastic Constructor.
```java
Runtastic runtastic = new Runtastic(new OkHttpRunClient());
```

Before you can access your details and activites you have to log in
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