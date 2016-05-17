package tw.wee.qas.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_question_by_id() {
        Question question = new Question("123456", "book id", "This is a questio");
        when(questionService.findQuestionById(question.getUuid())).thenReturn(question);

        ResponseEntity<?> responseEntity = questionController.findQuestionById(question.getUuid());

        verify(questionService).findQuestionById(question.getUuid());
        assertThat(responseEntity.getStatusCode(), is(OK));
        assertThat(responseEntity.getBody(), is(question));
    }
}
