package com.example.library.dto;

public class BookAuthorDTO {
    private Long bookId;
    private String title;
    private String genre;
    private String authorName;

    public BookAuthorDTO(Long bookId, String title, String genre, String authorName) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.authorName = authorName;
    }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
}
