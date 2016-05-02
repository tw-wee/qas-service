package tw.wee.qas.controller;

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

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookUuid}")
    public ResponseEntity<?> retrieveQuestions(@PathVariable String bookUuid) {
        Iterable<Question> questions = questionService.retrieveQuestions(bookUuid);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
