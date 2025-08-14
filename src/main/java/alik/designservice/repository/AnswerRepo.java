package alik.designservice.repository;

import alik.designservice.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

    @Query("SELECT a FROM Answer a WHERE a.email = :email")
    List<Answer> findByEmail(@Param("email") String email);


    @Query("SELECT a FROM Answer a WHERE a.question.id = :questionId")
    List<Answer> findByQuestionId(@Param("questionId") Long questionId);

}
