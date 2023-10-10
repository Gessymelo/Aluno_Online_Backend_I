package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create(Disciplina disciplina) {
        return repository.save(disciplina);}

    public List<Disciplina> findall() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById (Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Disciplina alterar(Disciplina disciplina){
        if(Objects.nonNull(disciplina.getId())){
            disciplina = repository.save(disciplina);
        }else{
            throw new NotFoundException();
        }
        return disciplina;
    }
}
