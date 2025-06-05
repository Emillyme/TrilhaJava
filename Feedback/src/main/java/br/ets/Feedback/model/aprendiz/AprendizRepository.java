package br.ets.Feedback.model.aprendiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AprendizRepository extends JpaRepository<Aprendiz, Integer> {
}
