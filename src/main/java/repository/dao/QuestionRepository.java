package repository.dao;

import model.Question;

public interface QuestionRepository {
    Question getRandom();

    void save(Question question);

    void delete(int id);
}
