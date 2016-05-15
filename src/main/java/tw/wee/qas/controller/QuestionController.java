package tw.wee.qas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.wee.qas.domain.Question;
import tw.wee.qas.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookId}")
    public ResponseEntity<?> retrieveQuestions(@PathVariable String bookId) {
        List<Question> questions = questionService.retrieveQuestions(bookId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
