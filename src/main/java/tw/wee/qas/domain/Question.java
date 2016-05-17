package tw.wee.qas.domain;

public class Question {
    private String uuid;
    private String bookId;
    private String content;

    public Question(String uuid, String bookId, String content) {
        this.uuid = uuid;
        this.bookId = bookId;
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
