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
import org.springframework.test.util.ReflectionTestUtils;

import tw.wee.qas.domain.Question;
import tw.wee.qas.entity.QuestionEntity;
import tw.wee.qas.mapper.QuestionMapper;
import tw.wee.qas.repository.QuestionRepository;

public class DefaultQuestionServiceTest {

    @InjectMocks
    private DefaultQuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(questionService, "mapper", new QuestionMapper());
    }

    @Test
    public void should_retrieve_questions_by_book_id() {
        String bookId = "book123456";
        List<QuestionEntity> questionEntities = asList(
                createQuestionEntity(bookId, "Question One"),
                createQuestionEntity(bookId, "Question Two"));
        when(questionRepository.findByBookId(bookId)).thenReturn(questionEntities);

        List<Question> questions = questionService.retrieveQuestions(bookId);

        assertThat(questions.size(), is(2));
        assertThat(questions.get(0).getBookId(), is(bookId));
        assertThat(questions.get(0).getContent(), is("Question One"));
    }

    private QuestionEntity createQuestionEntity(String bookId, String content) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setBookId(bookId);
        questionEntity.setContent(content);
        return questionEntity;
    }
}
