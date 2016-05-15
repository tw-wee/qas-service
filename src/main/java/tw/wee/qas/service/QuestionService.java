package tw.wee.qas.service;

import tw.wee.qas.entity.QuestionEntity;

public interface QuestionService {
    Iterable<QuestionEntity> retrieveQuestions(String bookUuid);
}
