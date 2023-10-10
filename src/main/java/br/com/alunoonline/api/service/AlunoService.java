package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository; //* injentando dependancia do repository no service*/

    public Aluno create(Aluno aluno) { //* cria um aluno*/
        return repository.save(aluno);

    }

    public List<Aluno> findall() { //* pesquisar por todos alunos*/
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) { //* pesquisar por um  alunos especifico*/
        return repository.findById(id);
    }

    public void delete(Long id) { //* Deleta um aluno especifico*/
        repository.deleteById(id);
    }

    public Aluno alterar(Aluno aluno){    //* Altera aluno especifico*/
        if(Objects.nonNull(aluno.getId())){
            aluno = repository.save(aluno);
        }else{
            throw new NotFoundException();
        }
        return aluno;
    }


}



