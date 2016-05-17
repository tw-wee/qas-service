package tw.wee.qas.controller;

import static java.lang.String.format;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void should_get_questions_by_book_uuid() throws Exception {
        String bookId = "book123";
        questionRepository.save(generateQuestion(bookId, "This is a question"));

        mockMvc.perform(get(format("/questions/book/%s", bookId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].bookId").value(bookId))
                .andExpect(jsonPath("$[0].content").value("This is a question"));
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

    private QuestionEntity generateQuestion(String bookId, String content) {
        QuestionEntity question = new QuestionEntity();
        question.setBookId(bookId);
        question.setContent(content);
        return question;
    }
}
