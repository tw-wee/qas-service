package tw.wee.qas.service;

import java.util.List;

import tw.wee.qas.domain.Question;

public interface QuestionService {
    List<Question> retrieveQuestions(String bookId);
}
