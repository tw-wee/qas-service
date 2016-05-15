package tw.wee.qas.repository;

import org.springframework.data.repository.CrudRepository;

import tw.wee.qas.entity.QuestionEntity;

public interface QuestionRepository extends CrudRepository<QuestionEntity, String> {
    Iterable<QuestionEntity> findByBook(String bookUuid);
}
