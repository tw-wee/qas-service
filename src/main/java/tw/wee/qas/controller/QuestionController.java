package tw.wee.qas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.wee.qas.domain.Question;
import tw.wee.qas.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookUuid}")
    public Iterable<Question> retrieveQuestions(@PathVariable String bookUuid) {
        return questionRepository.findByBook(bookUuid);
    }
}
