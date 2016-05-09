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
import tw.wee.qas.domain.Question;
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
        String bookUuid = "book123";
        questionRepository.save(generateQuestion(bookUuid, "This is a question"));

        mockMvc.perform(get(format("/questions/book/%s", bookUuid)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].book").value(bookUuid))
                .andExpect(jsonPath("$[0].content").value("This is a question"));
    }

    private Question generateQuestion(String bookUuid, String questionContent) {
        Question question = new Question();
        question.setBook(bookUuid);
        question.setContent(questionContent);
        return question;
    }
}