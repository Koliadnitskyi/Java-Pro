package repository;

import model.Question;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuestionRepositoryImplTest {
    private final String user = "postgres";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String password = "Slon1939net";
    private Connection connection;

    @Before
    public void init() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    @Test
    public void getTest() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        System.out.println(questionRepository.get(1));
    }

    @Test
    public void getByTopicTest() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        System.out.println(questionRepository.getByTopic("OOP"));
    }

    @Test
    public void deleteTest() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        questionRepository.delete(1);
    }

    @Test
    public void saveTest() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        questionRepository.save(new Question(1, "TestText", "TestTopic"));
    }

    @Test
    public void updateTest() {
        QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl(connection);
        questionRepository.update(new Question(1, "TestTextTwo", "TestTopicTwo"));
    }
}
