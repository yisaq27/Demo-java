import java.util.ArrayList;

public class Member {
   private int memberId;
   private String memberName;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    Member(int memberId,String memberName,Book borrowedBooks){
      this.memberId = memberId;
      this.memberName = memberName;
      this.borrowedBooks.add(borrowedBooks);
    }
    public int getMemberId() {
        return memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void getBorrowedBooks() {
        System.out.println("BookId\tTitle\t\tGenre");
       for (Book book : borrowedBooks) {
        System.out.println(book.getBookId()+"\t" +book.getTitle()+"\t" +book.getGenre());
       }
    }
    public void borrowBooks(Book book){
        borrowedBooks.add(book);
    }
    public void returnBooks(Book book){
        borrowedBooks.remove(book);
    }

    public void displayMemberDetails(){
        System.out.println(getMemberId()+" " +getMemberName());
        System.out.printf("Borrowed Book by %s",getMemberName());
        System.out.println();
        getBorrowedBooks();
    }
}
