package tw.wee.qas.service;

import tw.wee.qas.domain.Question;

public interface QuestionService {
    Iterable<Question> retrieveQuestions(String bookUuid);
}
