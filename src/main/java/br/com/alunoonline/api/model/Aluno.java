package br.com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor //* contrutor com argumetos */
@NoArgsConstructor //* contrutor sem argumetos */
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //* aqui formei a identidade do id para gera de 1 em 1)

    private Long id;

    @NotEmpty
    private String nome;

    @Email
    private String email;
    private String curso;
}
