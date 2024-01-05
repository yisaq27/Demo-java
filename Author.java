public class Author {
    private int authorId;
    private String authorName, bio;

    Author(int authorId, String authorName, String bio) {
        setAuthorId(authorId);
        setAuthorName(authorName);
        setBio(bio);
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        return getAuthorId() + "\t" + getAuthorName() + "\t" + getBio();
    }

    public String displayAuthorDetails(Author author) {
        return getAuthorId() + "\t   " + getAuthorName() + "\t" + getBio();
    }

}
