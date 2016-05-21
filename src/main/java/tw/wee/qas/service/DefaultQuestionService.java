package tw.wee.qas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.wee.qas.domain.Question;
import tw.wee.qas.entity.QuestionEntity;
import tw.wee.qas.exception.NotFoundException;
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
        QuestionEntity questionEntity = questionRepository.findOne(questionId);
        Optional.ofNullable(questionEntity).orElseThrow(() ->
                new NotFoundException("Question is not found!"));
        return mapper.map(questionEntity, Question.class);
    }

    @Override
    public List<Question> searchQuestions(String keyword) {
        List<QuestionEntity> questionEntities = questionRepository.findByContentContains(keyword);
        return mapper.mapList(questionEntities, Question.class);
    }
}
