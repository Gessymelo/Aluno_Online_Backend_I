package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import br.com.alunoonline.api.exceptions.IntegrityException;
import br.com.alunoonline.api.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Transactional
    public Professor create(Professor professor){
        return repository.save(professor);
    }

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void delete(Long id) {
        try {
            Professor professor = findById(id);
            repository.delete(professor);
            repository.flush();
        }
        catch (ResourceNotFoundException e){
            throw e;
        }
        catch(DataIntegrityViolationException e){
            throw new IntegrityException(id);
        }
    }

    public Professor update(Professor professor, Professor professorUpdated) {
        professor.setNome(professorUpdated.getNome());
        professor.setEmail(professorUpdated.getEmail());

        return repository.save(professor);
    }

}
