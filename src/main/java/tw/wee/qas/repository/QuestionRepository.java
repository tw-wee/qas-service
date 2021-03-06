package tw.wee.qas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tw.wee.qas.entity.QuestionEntity;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
    List<QuestionEntity> findByBookId(String bookId);

    List<QuestionEntity> findByContentContainingIgnoreCase(String keyword);

    QuestionEntity findByUuid(String uuid);
}
