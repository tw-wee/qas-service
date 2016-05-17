package tw.wee.qas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.wee.qas.domain.Question;
import tw.wee.qas.entity.QuestionEntity;
import tw.wee.qas.mapper.QuestionMapper;
import tw.wee.qas.repository.QuestionRepository;

@Service
@Transactional
public class DefaultQuestionService implements QuestionService {
    @Autowired
    private QuestionMapper mapper;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> retrieveQuestions(String bookId) {
        List<QuestionEntity> questionEntities = questionRepository.findByBookId(bookId);
        return mapper.mapList(questionEntities, Question.class);
    }

    @Override
    public Question findQuestionById(String questionId) {
        return null;
    }
}
