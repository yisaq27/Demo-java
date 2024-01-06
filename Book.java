public class Book extends Author{
   private int bookId,totalcopies,availableCopies;
    private String title,genre;
    private Author author;

    Book(int bookId, int totalcopies, int availableCopies,String title, Author author, String genre){
        super(author.getAuthorId(),author.getAuthorName(),author.getBio());
        setBookId(bookId);
        setTitle(title);
        setGenre(genre);
        setTotalcopies(totalcopies);
        setAvailableCopies(availableCopies);

    }
    
public void setBookId(int bookId) {
    this.bookId = bookId;
}
public int getBookId() {
    return bookId;
}
public void setTotalcopies(int totalcopies) {
    this.totalcopies = totalcopies;
}
public int getTotalcopies() {
    return totalcopies;
}
public void setAvailableCopies(int availableCopies) {
    this.availableCopies = availableCopies;
}
public int getAvailableCopies() {
    return availableCopies;
}
public void setTitle(String title) {
    this.title = title;
}
public String getTitle() {
    return title;
}
public void setGenre(String genre) {
    this.genre = genre;
}
public String getGenre() {
    return genre;
}
public Author getAuthor() {
    return author ;
}

public String displayBookDetails(){
    return getBookId()+ "\t" + getTitle() +"\t"  + displayAuthorDetails(author) +"\t"  + getGenre() +"\t\t" + getAvailableCopies()+"\t" +getTotalcopies();
}


}
