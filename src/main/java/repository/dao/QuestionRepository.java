package repository.dao;

import model.Question;

public interface QuestionRepository {
    Question get(int id);

    Question getRandom();

    int getSizeBase();

    void save(Question question);
    void delete (int id);
}
