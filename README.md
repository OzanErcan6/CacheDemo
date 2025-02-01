# Caching Demo with Spring Boot

This project demonstrates the usage of caching in a Spring Boot application, showcasing how to use `@Cacheable`, `@CachePut`, and `@CacheEvict` annotations for managing caches effectively. The demo operates with a simple in-memory H2 database and performs basic CRUD operations on `User` entities while illustrating how caching can improve performance by reducing redundant database calls.

## What is Caching?

Caching is a technique used to store frequently accessed data in a temporary storage (called the "cache") so that future requests for the same data can be served faster without needing to access the underlying data source (like a database). This is particularly useful for scenarios where data doesn't change often and is read frequently.

In this project, we use caching to store user data in memory, allowing faster access to user details by skipping database lookups once the data is cached.

## Why is Caching Important?

Caching is essential for improving application performance, especially for read-heavy workloads. When data retrieval from a database or an external service is expensive in terms of time or resources, caching can significantly reduce response times and server load. By storing the results of previous requests, caching ensures that subsequent requests for the same data are served from the cache instead of querying the database again.

Here are some benefits of caching:
- **Faster Response Times**: Reduces the time it takes to fetch frequently accessed data.
- **Reduced Load on Database**: Minimizes the number of database queries, improving scalability.
- **Improved User Experience**: Provides quicker access to data, enhancing the responsiveness of the application.

## Setup and Run

1. Clone the repository:

   ```bash
   git clone https://github.com/OzanErcan6/CacheDemo.git
   ```

2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Make sure your Java version is 17 or later.

4. Run the Spring Boot application from your IDE.

5. To access the H2 console (for viewing the in-memory database), navigate to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) in your browser.

## Caching in the Project

### Annotations Used:

- **`@Cacheable`**: This annotation is used to cache the result of a method. If the method is called again with the same parameters, the cached result will be returned without executing the method again.
  
- **`@CachePut`**: This annotation is used to update the cache with the new value after the method execution, even if the result is already cached.
  
- **`@CacheEvict`**: This annotation is used to remove a specific item or all items from the cache when a method is executed.

### Example Use Cases:
- **`@Cacheable`**: Caches the result of fetching a user by ID. The next time the same user is requested, the data is served directly from the cache.
- **`@CachePut`**: Updates the cache when a user’s details are modified, ensuring that the cache reflects the most recent changes.
- **`@CacheEvict`**: Removes the user from the cache when they are deleted, ensuring that the cache is consistent with the current state of the database.

## Testing Caching Behavior

The demo includes unit tests that validate the caching functionality:
- **`getUserWithId1`**: Ensures that the user data is cached and reused for subsequent requests.
- **`getUserWithId1AndUpdateIt`**: Verifies that when a user is updated, the cache is refreshed with the new data.
- **`getUserWithId1AndDeleteIt`**: Confirms that the cache is cleared when a user is deleted.

These tests are designed to ensure that the caching mechanism works as expected and provides performance benefits by reducing unnecessary database queries.
