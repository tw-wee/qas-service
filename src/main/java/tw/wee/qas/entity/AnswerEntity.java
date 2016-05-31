package tw.wee.qas.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wee_answer")
public class AnswerEntity extends AuditorEntity {

    @Column(name = "uuid", nullable = false, unique = true, length = 64, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "question_id", nullable = false, length = 64)
    private String questionId;

    @Column(name = "content", nullable = false)
    private String content;

    public String getUuid() {
        return uuid;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
