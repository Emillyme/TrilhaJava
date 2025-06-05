package br.ets.Feedback.model.instrutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
    Page<Instrutor> findAllByAtivoTrue(Pageable pageable);
}
