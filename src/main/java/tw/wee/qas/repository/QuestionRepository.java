package tw.wee.qas.repository;

import org.springframework.data.repository.CrudRepository;

import tw.wee.qas.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, String> {
    Iterable<Question> findByBook(String bookUuid);
}
