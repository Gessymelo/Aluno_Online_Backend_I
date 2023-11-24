package br.com.alunoonline.api.model.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoDto {
    private String nomeAluno;
    private String curso;
    private List<DisciplinasDto> disciplinas;
}
