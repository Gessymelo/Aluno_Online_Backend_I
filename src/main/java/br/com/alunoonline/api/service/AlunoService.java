package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import br.com.alunoonline.api.exceptions.IntegrityException;
import br.com.alunoonline.api.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository; //* injentando dependancia do repository no service*/


    @Transactional
    public Aluno create(Aluno aluno){   //* cria um aluno*/
        return this.repository.save(aluno);
    }

    public List<Aluno> findAll(){ //* pesquisar por todos alunos*/
        return this.repository.findAll();
    }

    public Aluno findById(Long id){ //* pesquisar por um  alunos especifico*/
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void delete(Long id){  //* Deleta um aluno especifico*/
        try {
            Aluno aluno = findById(id);
            repository.delete(aluno);
            repository.flush();
        }
        catch (ResourceNotFoundException e){
            throw e;
        }
        catch(DataIntegrityViolationException e){
            throw new IntegrityException(id);
        }
    }
    //Atualiza dados dos Aluno
    public Aluno update(Aluno aluno, Aluno alunoUpdated) {
        aluno.setNome(alunoUpdated.getNome());
        aluno.setEmail(alunoUpdated.getEmail());
        aluno.setCurso(alunoUpdated.getCurso());

        return repository.save(aluno);
    }



}



