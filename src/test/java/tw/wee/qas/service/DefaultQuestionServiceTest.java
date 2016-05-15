package tw.wee.qas.service;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tw.wee.qas.domain.Question;
import tw.wee.qas.repository.QuestionRepository;

public class DefaultQuestionServiceTest {

    @InjectMocks
    private DefaultQuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_retrieve_questions_by_book_uuid() {
        String bookUuid = "book123456";
        List<Question> expectedQuestions = asList(new Question(), new Question());
        when(questionRepository.findByBook(bookUuid)).thenReturn(expectedQuestions);

        Iterable<Question> questions = questionService.retrieveQuestions(bookUuid);

        assertThat(questions, is(expectedQuestions));
    }
}