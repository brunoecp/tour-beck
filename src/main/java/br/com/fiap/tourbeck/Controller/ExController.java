package br.com.fiap.tourbeck.Controller;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Exception.RestNotFoundException;
import br.com.fiap.tourbeck.models.Despesa;
import br.com.fiap.tourbeck.repository.ContaExRepository;
import br.com.fiap.tourbeck.repository.DespesaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/despesas")
public class ExController {
    
    @Autowired
    DespesaRepository despesaRepository;
    @Autowired
    ContaExRepository contaRepository;
    @Autowired
    PagedResourcesAssembler<Object> assembler;
    Logger log = LoggerFactory.getLogger(ExController.class);

    //GET ALL
    @GetMapping
    public PagedModel<EntityModel<Object>> Home(@RequestParam(required = false) String busca,@PageableDefault(size = 5, page = 0) Pageable pag){
        Page<Despesa> despesas= (busca == null) ?
            despesaRepository.findAll(pag): 
            despesaRepository.findByDescricaoContaining(busca, pag);

        return assembler.toModel(despesas.map(Despesa::toEntityModel));
        //return despesas.map(Despesa::toEntityModel);
    }
    //GET
    @GetMapping("{id}")
    public EntityModel<Despesa> show(@PathVariable Long id) {    
        
        return getDespesa(id).toEntityModel();
    }
    //POST 
    @PostMapping
    public ResponseEntity<EntityModel<Despesa>> create(@RequestBody @Valid Despesa despesa, BindingResult result){
        log.info("despesa cadastrada " + despesa);
        despesaRepository.save(despesa);
        despesa.setConta(contaRepository.findById(despesa.getConta().getId()).get());

        return (ResponseEntity<EntityModel<Despesa>>) ResponseEntity.created(despesa.toEntityModel().getRequiredLink("self").toUri()).body(despesa.toEntityModel());
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Despesa> delete(@PathVariable Long id) {
        log.info("apagando despesa: " + id);
         despesaRepository.delete(getDespesa(id));
        return ResponseEntity.noContent().build();
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody @Valid Despesa despesa) {
        getDespesa(id);

        despesa.setId(id);
        
        despesaRepository.save(despesa);
        return ResponseEntity.ok(despesa);
    }

    private Despesa getDespesa(Long id) {
        return despesaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Despesa não encontrada"));
    }
}
