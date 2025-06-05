package br.ets.Feedback.controller;

import br.ets.Feedback.model.aprendiz.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("aprendiz")
public class AprendizController {
    @Autowired
    private AprendizRepository repository;

    @PostMapping
    public ResponseEntity<DadosListagemAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dadosCadastroAprendiz, UriComponentsBuilder uriComponentsBuilder){
        var aprendiz = new Aprendiz(dadosCadastroAprendiz);
        repository.save(aprendiz);
        var uri = uriComponentsBuilder.path("/aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAprendiz(aprendiz));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAprendiz>> listar(Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemAprendiz::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosListagemAprendiz> atualizar(@RequestBody @Valid DadosAtualizadoAprendiz dadosAtualizadoAprendiz) {
        var aprendiz = repository.getReferenceById(dadosAtualizadoAprendiz.id());
        aprendiz.atualizar(dadosAtualizadoAprendiz);
        return ResponseEntity.ok(new DadosListagemAprendiz(aprendiz));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Aprendiz> excluir (@PathVariable int id){
        var aprendiz = repository.getReferenceById(id);
        repository.delete(aprendiz);
        return ResponseEntity.noContent().build();
    }
}
