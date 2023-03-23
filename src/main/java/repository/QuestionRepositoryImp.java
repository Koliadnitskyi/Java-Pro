package repository;

import Exceptions.SqlDeleteException;
import Exceptions.SqlGetException;
import Exceptions.SqlSaveException;
import model.Question;
import repository.dao.QuestionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionRepositoryImp implements QuestionRepository {

    private int getSizeDatabase() {
        int sizeBaseQuestions;
        try {
            PreparedStatement preparedStatement = ConnectionSingelton.getConnection().prepareStatement("select count(*)");
            ResultSet question = preparedStatement.executeQuery();
            sizeBaseQuestions = question.getInt(1);
        } catch (SQLException e) {
            throw new SqlGetException(e.getMessage());
        }
        return sizeBaseQuestions;
    }

    @Override
    public Question getRandom() {
        try {

            PreparedStatement preparedStatementTwo = ConnectionSingelton.getConnection().prepareStatement("SELECT * FROM Questions where id=?");
            preparedStatementTwo.setInt(1, ThreadLocalRandom.current().nextInt(1, new QuestionRepositoryImp().getSizeDatabase()));
            ResultSet questionTwo = preparedStatementTwo.executeQuery();
            questionTwo.next();
            return Question.builder()
                    .id(questionTwo.getInt("id"))
                    .text(questionTwo.getString("text"))
                    .topic(questionTwo.getString("topic"))
                    .build();
        } catch (SQLException e) {
            throw new SqlGetException(e.getMessage());
        }
    }

    @Override
    public void save(Question question) {
        try {
            PreparedStatement preparedStatement = ConnectionSingelton.getConnection().prepareStatement("INSERT INTO Questions VALUE (?,?,?)");
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setString(2, question.getText());
            preparedStatement.setString(3, question.getTopic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlSaveException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionSingelton.getConnection().prepareStatement("DELETE FROM Questions where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlDeleteException(e.getMessage());
        }
    }
}
