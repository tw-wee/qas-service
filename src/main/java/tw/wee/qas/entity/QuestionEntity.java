package tw.wee.qas.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wee_question")
public class QuestionEntity extends AuditorEntity {
    @Id
    @Column(name = "uuid", nullable = false, length = 64, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "book", nullable = false, length = 64)
    private String bookId;

    @Column(name = "content", nullable = false)
    private String content;

    public String getUuid() {
        return uuid;
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
