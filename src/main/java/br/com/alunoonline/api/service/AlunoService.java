package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository; //* injentando dependancia do repository no service*/

    public Aluno create(Aluno aluno) { //* cria um aluno*/
       return repository.save(aluno);

    }

    public List<Aluno> findall(){ //* pesquisar por todos alunos*/
         return repository.findAll();
    }

    public Optional<Aluno> findById(Long id){ //* pesquisar por um  alunos especifico*/
        return repository.findById(id);
    }

    public void delete(Long id){ //* Deleta um aluno especifico*/
        repository.deleteById(id);
    }





}
