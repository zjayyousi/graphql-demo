# Introduction to GraphQL

## Getting Started
This is a demo Spring Boot, Gradle project for GraphQL.

### Reference Documentation
Application Requirements:
* Java 8+
* H2 In-Memory Database (Demo only, not suitable for production)
* GraphQL Dependencies for Spring Boot with Gradle:
```
compile group: 'com.graphql-java', name: 'graphql-spring-boot-starter', version: '5.0.2'
compile group: 'com.graphql-java', name: 'graphiql-spring-boot-starter', version: '5.0.2'
compile group: 'com.graphql-java', name: 'graphql-java-tools', version: '5.2.4'
```

### Guides

#### Running the applications & Using GraphiQL & H2-DB Console:
1. Run the demo application: <br/>
    * `./gradlew bootRun`

2. GraphiQL Web Tool is a user-friendly GUI for constructing Queries and Mutation operations: <br/>
    * `http://localhost:8080/graphiql`

3. H2 In-Memory Database Console for checking records if needed:
    * Web URL: `http://localhost:8080/h2-console`
    * Driver Class: `org.h2.Driver`
    * JDBC URL: `jdbc:h2:mem:test`
    * Username: user
    * Password: password
    
 
#### Sample Data and Code: ####
* The application has a sample data that is bootstrapped in the following file:
    `src/main/java/de/neofonie/techly/graphql/SetupDataLoader.java`
    
* The entities include Author, Post, Comments as a simple blog with one to many relations and relevant repositories.
    `src/main/java/de/neofonie/techly/graphql/persistence/*`
    
* Few services to run queries and mutation operations such as read and save:
    `src/main/java/de/neofonie/techly/graphql/services/*`    

* GraphQL specific resolvers for Queries and Mutations that bind GraphQL schema methods to services:
    `src/main/java/de/neofonie/techly/graphql/query/*`
    `src/main/java/de/neofonie/techly/graphql/mutation/*`
    
* A GraphQL schema file that contains types and methods:
    `resources/graphql/schema.graphqls`
 
#### Queries ####
* Queries are GET calls for single endpoint with a parameter, e.g.: ?query={posts{.....}}
* There are client libraries for GraphQL to construct such HTTP GET queries.
* Fields and methods are documented in the right hand panel titled `Documentation Explorer`
* To test GraphQL queries, in the GUI tool `GraphiQL`, see link above, here is an example query to get all posts, related author and comments:
```
    query {
      posts {
        id
        title
        content
        created
        author {
          id
          name
        }
        comments {
          id
          content
          created
        }
      }
    }
```
* The query above could be modified with more or less fields and types, for example `author` could be removed if not needed or any other fields.
* The query is flexible on the client side where we could ask only for hte data we need, here is a different version of the query:
```
    query {
      posts {
        title
        created
        comments {
          content
          created
        }
      }
    }
```

#### Mutations ####
* Mutations are HTTP POST requests to predefined methods.
* The following mutation example demonstrates how we create a new `comment` by adding required fields `post_id` and `content` as parameters. Also, we could define the response of the operation and type of data, to be returned from the response, in the body of `createComment` method.
```
mutation {
  createComment(post_id: 8, content: "TEST") {
    id
    content
    post {
      id
      title
    }
  }
}
```
* The `createComment` mutation method maps to the backend `CommentMutation.createComment` method which uses service method `CommentService.createComment` to create a new comment. 
* Fields and methods are documented in the right hand panel titled `Documentation Explorer`.


#### Subscriptions ####
* Subscriptions are event-based, pushed updates from the server to the client when data is added or updated.
* No example in this demo since it requires implementation on the client side as well.

### Additional Links
Official GraphQL Documentation:
* [GraphQL](https://graphql.org)

GraphQL Clients & Servers:
* [Android, iOS, Web, React.js and More](https://www.apollographql.com/docs)
* [Relay](https://relay.dev)
* [DataLoader](https://github.com/graphql/dataloader)
* [GraphQL Request](https://github.com/prisma-labs/graphql-request)
* [Prisma](https://www.prisma.io)
* [Graph Cool](https://github.com/prisma/graphcool-framework)
