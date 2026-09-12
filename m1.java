class LibraryBook {
    String title;
    String isbn;
    boolean catalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn;
        }
        this.catalogued = true;
    }

    public LibraryBook(String title) {
        this(title, "");
    }

    void printStatus() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        LibraryBook[] books = new LibraryBook[titles.length];

        for (int i = 0; i < titles.length; i++) {
            books[i] = new LibraryBook(titles[i], isbns[i]);
        }

        for (LibraryBook book : books) {
            book.printStatus();
        }
    }
}
