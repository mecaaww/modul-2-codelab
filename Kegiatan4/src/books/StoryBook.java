package books;

public class StoryBook extends Book {

    String category = "Story";

    public StoryBook(String bookId, String title, String author, int stock) {
        super(bookId, title, author, stock);
        setCategory(category);
    }
}
