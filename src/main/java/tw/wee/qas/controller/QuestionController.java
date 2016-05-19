package tw.wee.qas.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.wee.qas.domain.Question;
import tw.wee.qas.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = GET)
    public ResponseEntity<?> retrieveQuestions(@RequestParam(value = "book", required = true) String bookId) {
        List<Question> questions = questionService.retrieveQuestions(bookId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/{questionId}")
    public ResponseEntity<?> findQuestionById(@PathVariable("questionId") String questionId) {
        Question question = questionService.findQuestionById(questionId);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
