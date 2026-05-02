# Library Management System — Spring Boot

A Spring Boot web application to manage **Authors** and **Books** with full Create, Read, and Update operations using JPA, JSP views, and an H2 in-memory database.

## Entities

| Entity | Attributes | Relationship |
|--------|-----------|--------------|
| `Author` | id, name | One Author → Many Books |
| `Book` | id, title, genre, author | Many Books → One Author |

## Tech Stack

- **Backend**: Spring Boot 3.2.5, Spring MVC, Spring Data JPA
- **Database**: H2 In-Memory (auto-populated with 10 Authors + 10 Books on startup)
- **View**: JSP + JSTL + CSS
- **Build**: Maven (mvnw wrapper included)
- **Tests**: JUnit 5 + Mockito

## Project Structure

```
src/
├── main/java/com/example/library/
│   ├── config/         DataInitializer.java      (seeds 10 rows each)
│   ├── controller/     LibraryController.java
│   ├── dto/            BookAuthorDTO.java         (INNER JOIN result)
│   ├── entity/         Author.java, Book.java
│   ├── repository/     AuthorRepository.java, BookRepository.java
│   └── service/        LibraryService.java
└── main/webapp/WEB-INF/views/
    ├── list.jsp         (READ — shows all books with authors)
    ├── add.jsp          (CREATE — form to add a book)
    └── update.jsp       (UPDATE — pre-filled edit form)
```

## Running the Application

```bash
./mvnw spring-boot:run
```

Then visit: [http://localhost:8080](http://localhost:8080)

## Running Tests

```bash
./mvnw test
```

All 3 tests pass:
- `BookRepositoryTest` — tests custom INNER JOIN `@Query`
- `LibraryServiceTest` — tests `addBook()` using Mockito
- `LibraryApplicationTests` — Spring context load test

## Key Features

- **Populate**: 10 Authors and 10 Books auto-seeded via `DataInitializer` on startup
- **Create**: Form at `/library/add` with exception handling for integrity violations
- **Read**: Table at `/library` using custom JPQL INNER JOIN query
- **Update**: Pre-filled form at `/library/update/{id}`
- **H2 Console**: Available at `/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## Custom INNER JOIN Query

```java
@Query("SELECT new com.example.library.dto.BookAuthorDTO(b.id, b.title, b.genre, a.name) " +
       "FROM Book b INNER JOIN b.author a")
List<BookAuthorDTO> findBooksWithAuthors();
```
