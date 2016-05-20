package tw.wee.qas.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.wee.qas.domain.Question;
import tw.wee.qas.service.QuestionService;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = GET, value = "/books/{bookId}/questions")
    public ResponseEntity<?> retrieveQuestions(@PathVariable("bookId") String bookId) {
        List<Question> questions = questionService.retrieveQuestions(bookId);
        return new ResponseEntity<>(questions, OK);
    }

    @RequestMapping(method = GET, value = "/questions/{questionId}")
    public ResponseEntity<?> findQuestionById(@PathVariable("questionId") String questionId) {
        Question question = questionService.findQuestionById(questionId);
        return new ResponseEntity<>(question, OK);
    }

    @RequestMapping(method = GET, value = "/questions")
    public ResponseEntity<?> searchQuestions(@RequestParam(value = "keyword", required = true) String keyword) {
        List<Question> questions = questionService.searchQuestions(keyword);
        return new ResponseEntity<>(questions, OK);
    }
}
