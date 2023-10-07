package br.com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor //* contrutor com argumetos */
@NoArgsConstructor //* contrutor sem argumetos */
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //* aqui formei a identidade do id para gera de 1 em 1)
    private Long id;
    private String nome;
    private String email;
    private String curso; //* refatora essa parte futuramente *//
}
