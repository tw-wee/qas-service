package tw.wee.qas.service;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
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
import tw.wee.qas.exception.NotFoundException;
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

    @Test
    public void should_find_question_by_question_id() {
        QuestionEntity questionEntity = createQuestionEntity("book id", "This is a question!");
        when(questionRepository.findByUuid(questionEntity.getUuid())).thenReturn(questionEntity);

        Question question = questionService.findQuestionById(questionEntity.getUuid());

        assertThat(question.getUuid(), is(questionEntity.getUuid()));
        assertThat(question.getBookId(), is(questionEntity.getBookId()));
        assertThat(question.getContent(), is(questionEntity.getContent()));
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_exception_when_not_find_question_by_id() {
        String questionId = "1234";
        when(questionRepository.findByUuid(questionId)).thenReturn(null);

        questionService.findQuestionById(questionId);
    }

    @Test
    public void should_search_question_given_keyword() {
        String keyword = "test";
        List<QuestionEntity> questionEntities = asList(
                createQuestionEntity("123", "a test question"),
                createQuestionEntity("456", "another test question"));
        when(questionRepository.findByContentContainingIgnoreCase(keyword)).thenReturn(questionEntities);

        List<Question> questions = questionService.searchQuestions(keyword);

        assertThat(questions.size(), is(2));
        assertThat(questions.get(0).getContent(), containsString(keyword));
        assertThat(questions.get(1).getContent(), containsString(keyword));
    }

    private QuestionEntity createQuestionEntity(String bookId, String content) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setBookId(bookId);
        questionEntity.setContent(content);
        return questionEntity;
    }
}
