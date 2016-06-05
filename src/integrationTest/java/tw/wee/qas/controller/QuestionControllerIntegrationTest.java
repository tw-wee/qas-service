package tw.wee.qas.controller;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import tw.wee.qas.ApplicationIntegrationTest;
import tw.wee.qas.entity.QuestionEntity;
import tw.wee.qas.repository.QuestionRepository;

public class QuestionControllerIntegrationTest extends ApplicationIntegrationTest {
    @Autowired
    private QuestionController questionController;

    @Autowired
    private QuestionRepository questionRepository;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
    }

    @Test
    public void should_get_questions_by_book_id() throws Exception {
        String bookId = "book123";
        questionRepository.save(generateQuestion(bookId, "This is a question"));


    }

    @Test
    public void should_find_question_by_id() throws Exception {
        QuestionEntity savedQuestion = questionRepository.save(
                generateQuestion("book id", "This is a Question!"));

        mockMvc.perform(get(format("/questions/%s", savedQuestion.getUuid())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid").value(savedQuestion.getUuid()))
                .andExpect(jsonPath("$.bookId").value(savedQuestion.getBookId()))
                .andExpect(jsonPath("$.content").value(savedQuestion.getContent()));
    }

    @Test
    public void should_search_questions_by_keyword_ignore_cases() throws Exception {
        questionRepository.save(generateQuestion("book id", "This is an old question"));
        questionRepository.save(generateQuestion("book123", "This is a new question"));
        questionRepository.save(generateQuestion("book456", "This is another new question"));

        String keyword = "NEW";
        Matcher<String> keywordMatcher = containsString(keyword.toLowerCase());
        mockMvc.perform(get(format("/questions?keyword=%s", keyword)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].content").value(keywordMatcher))
                .andExpect(jsonPath("$[1].content").value(keywordMatcher));

    }

    private QuestionEntity generateQuestion(String bookId, String content) {
        QuestionEntity question = new QuestionEntity();
        question.setBookId(bookId);
        question.setContent(content);
        return question;
    }
}
