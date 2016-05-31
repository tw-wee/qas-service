package tw.wee.qas.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wee_question")
public class QuestionEntity extends AuditorEntity {

    @Column(name = "uuid", nullable = false, unique = true, length = 64, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "user_id", nullable = false, length = 64)
    private String userId = "me";

    @Column(name = "book_id", nullable = false, length = 64)
    private String bookId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "status", nullable = false, length = 16)
    private String status = "ENABLED";

    public String getUuid() {
        return uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
