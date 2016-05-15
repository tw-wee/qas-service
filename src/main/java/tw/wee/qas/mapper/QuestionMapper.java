package tw.wee.qas.mapper;

import org.springframework.stereotype.Component;

import tw.wee.qas.domain.Question;
import tw.wee.qas.entity.QuestionEntity;

@Component
public class QuestionMapper extends BaseMapper {
    public QuestionMapper() {
        register(QuestionEntity.class, Question.class);
    }
}
