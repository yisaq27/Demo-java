public class Main {
    public static void main(String[] args) {
        Author author1 = new Author(901, "F.Scott", "American Novelist");
        Author author2 = new Author(903, "F.Scott", "American Novelist");
        Book book1 = new Book(801, 10, 5, "The Great Spy", author1, "Fiction");
        Book book2 = new Book(802, 10, 5, "The Hacker", author2, "Fiction");
        Member member1 = new Member(1001, "Emma", book1);
        Member member2 = new Member(1002, "Emma", book2);
        Library library = new Library();
        member1.borrowBooks(book2);
        member1.borrowBooks(book2);
        member1.returnBooks(book1);
        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);
        library.removeBook(book2);
        library.libraryStatus();
        
        
    }
}
