package ConverterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Jpa_playground.smy.converters_demo.Question;
import jakarta.persistence.EntityManager;
import java.util.UUID;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConverterTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void whenFieldAnnotatedWithYesNoConverter_ThenConversionWorks() {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        UUID coffeeQuestionId = UUID.randomUUID();
        UUID nyIsCapitalQuestionId = UUID.randomUUID();
        session.persist(Question.builder()
            .id(coffeeQuestionId)
            .content("Do you like coffee?")
            .correctAnswer(true)
            .shouldBeAsked(true)
            .isEasy(true)
            .wasAskedBefore(false)
            .build());
        session.persist(Question.builder()
            .id(nyIsCapitalQuestionId)
            .content("Is New York the capital of USA?")
            .correctAnswer(false)
            .shouldBeAsked(true)
            .isEasy(false)
            .wasAskedBefore(false)
            .build());
        session.flush();

        char coffeeQuestionCorrectAnswerDbValue = (char) session.createNativeQuery(String.format("SELECT correctAnswer FROM Question WHERE id='%s'", coffeeQuestionId.toString()))
            .getSingleResult();
        char nyIsCapitalQuestionCorrectAnswerDbValue = (char) session.createNativeQuery(String.format("SELECT correctAnswer FROM Question WHERE id='%s'", nyIsCapitalQuestionId.toString()))
            .getSingleResult();
        session.close();

        assertEquals('Y', coffeeQuestionCorrectAnswerDbValue);
        assertEquals('N', nyIsCapitalQuestionCorrectAnswerDbValue);
    }
}
