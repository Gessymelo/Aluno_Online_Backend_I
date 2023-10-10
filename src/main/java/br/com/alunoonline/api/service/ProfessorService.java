package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create(Professor professor){
        return repository.save(professor);
    }

    public List<Professor> findall() {
        return repository.findAll();
    }

    public Optional<Professor> findById (Long id) {
        return repository.findById(id);
    }

    public void delete (Long id) {
        repository.deleteById(id);
    }

    public Professor alterar(Professor professor){
        if(Objects.nonNull(professor.getId())){
            professor = repository.save(professor);
        }else{
            throw new NotFoundException();
        }
        return professor;
    }

}
