
# Caching Demo with Spring Boot

This project demonstrates the usage of caching in a Spring Boot application, showcasing how to use `@Cacheable`, `@CachePut`, and `@CacheEvict` annotations for managing caches effectively. The demo operates with a simple in-memory H2 database and performs basic CRUD operations on `User` entities while illustrating how caching can improve performance by reducing redundant database calls.

## Setup and Run

1. Clone the repository:

   ```bash
   git clone https://github.com/OzanErcan6/CacheDemo.git
   ```
2. **Select Branch**:
   - For the default Spring cache, choose the `master` branch.
   - For Redis setup, choose the `redis` branch.
3. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

4. Make sure your Java version is 17 or later.

7. Redis Setup (For Redis Branch Only):

   To run Redis, execute the following Docker command:

   ```bash
   docker run --name redis -p 6379:6379 -d redis
   ```

5. Run the Spring Boot application from your IDE.

6. To access the H2 console (for viewing the in-memory database), navigate to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) in your browser.


   This will run Redis in a Docker container and expose it on port 6379. Ensure that Redis is up and running before starting the Spring Boot application.

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

The demo includes unit tests that validate the caching functionality.
