package model;

public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String id, String title, String author, String genre, String availabilityStatus) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("Book ID cannot be empty.");
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author cannot be empty.");
        if (!availabilityStatus.equalsIgnoreCase("Available") && !availabilityStatus.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Availability status must be 'Available' or 'Checked Out'.");
        }

        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setAvailabilityStatus(String availabilityStatus) { 
        if (!availabilityStatus.equalsIgnoreCase("Available") && !availabilityStatus.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Invalid availability status.");
        }
        this.availabilityStatus = availabilityStatus; 
    }

    @Override
    public String toString() {
        return "Book[ID=" + id + ", Title=" + title + ", Author=" + author + 
               ", Genre=" + genre + ", Status=" + availabilityStatus + "]";
    }
}
