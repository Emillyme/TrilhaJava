package br.ets.Feedback.controller;

import br.ets.Feedback.model.instrutor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    public ResponseEntity<DadosListagemInstrutor> cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor, UriComponentsBuilder uriComponentsBuilder){
        var instrutor = new Instrutor(dadosCadastroInstrutor);
        repository.save(instrutor);
        var uri = uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar(Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosListagemInstrutor> atualizar(@RequestBody @Valid DadosAtualizadoInstrutor dadosAtualizadoInstrutor){
        var instrutor = repository.getReferenceById(dadosAtualizadoInstrutor.id());
        instrutor.atualizar(dadosAtualizadoInstrutor);
        return ResponseEntity.ok(new DadosListagemInstrutor(instrutor));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> excluir (@PathVariable int id){
        var instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosInformacoesCompletasDoInstrutor> detalharInstrutor(@PathVariable int id){
        var instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompletasDoInstrutor(instrutor));
    }
}
