package tw.wee.qas.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wee_question")
public class Question extends Auditor {
    @Id
    @Column(name = "uuid", nullable = false, length = 64, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "book", nullable = false, length = 64)
    private String book;

    @Column(name = "content", nullable = false)
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
