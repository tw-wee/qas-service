package tw.wee.qas.controller;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import tw.wee.qas.domain.Question;
import tw.wee.qas.service.QuestionService;

public class QuestionControllerTest {

    @InjectMocks
    private QuestionController questionController;

    @Mock
    private QuestionService questionService;
    private Question question;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        question = new Question("123456", "book id", "This is a question");
    }

    @Test
    public void should_retrieve_questions_when_given_book_id() {
        String bookId = question.getBookId();
        List<Question> questions = asList(question, question);
        when(questionService.retrieveQuestions(bookId)).thenReturn(questions);

        ResponseEntity<?> responseEntity = questionController.retrieveQuestions(bookId);

        verify(questionService).retrieveQuestions(bookId);
        assertThat(responseEntity.getStatusCode(), is(OK));
        assertThat(responseEntity.getBody(), is(questions));
    }

    @Test
    public void should_find_question_by_id() {
        when(questionService.findQuestionById(question.getUuid())).thenReturn(question);

        ResponseEntity<?> responseEntity = questionController.findQuestionById(question.getUuid());

        verify(questionService).findQuestionById(question.getUuid());
        assertThat(responseEntity.getStatusCode(), is(OK));
        assertThat(responseEntity.getBody(), is(question));
    }

    @Test
    public void should_search_question_by_keyword() {
        String keyword = "question";
        List<Question> questions = asList(question, question);
        when(questionService.searchQuestions(keyword)).thenReturn(questions);

        ResponseEntity<?> responseEntity = questionController.searchQuestions(keyword);

        verify(questionService).searchQuestions(keyword);
        assertThat(responseEntity.getStatusCode(), is(OK));
        assertThat(responseEntity.getBody(), is(questions));
    }
}
