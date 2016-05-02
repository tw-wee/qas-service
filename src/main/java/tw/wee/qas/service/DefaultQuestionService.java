package tw.wee.qas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.wee.qas.domain.Question;
import tw.wee.qas.repository.QuestionRepository;

@Service
@Transactional
public class DefaultQuestionService implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Iterable<Question> retrieveQuestions(String bookUuid) {
        return questionRepository.findByBook(bookUuid);
    }
}
