import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Author> authorList = new ArrayList<>();
    ArrayList<Member> memberList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void removeMember(Member member) {
        memberList.remove(member);
    }

    public void libraryStatus() {
        System.out.println();
        System.out.println();
        System.out.println("The Library has these number of memebers:");
        
        for (Member member : memberList) {
            System.out.println("Id   Name");
           member.displayMemberDetails();
           System.out.println();
        
        }
        System.out.println();
        System.out.println();
        System.out.println("The Library has these types of book: ");
        System.out.println();
        System.out.println("BookId\t\tTitle\tAuthorId  AuthorName\tBio\t\t\tGenre\t  Avialable\tTotal");
        for (Book book : bookList) {
            System.out.println(book.displayBookDetails());
        }

        System.out.println();
        System.out.println();

    }

}
