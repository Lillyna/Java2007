package course3.lesson7;

public class Book {
    @MyAnnot(name = "")
    private String title;
    private String author;
    private int year;
    private String publisher;

    public Book() {

    }

    @MyAnnotation(name = "")
    @MyAnnot(name = "fff")
    public void setTitle(@MyAnnot (name = "ppp") String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
