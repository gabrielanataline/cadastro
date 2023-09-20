package com.itau.estagiaria.models.dtos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.itau.estagiaria.models.DadosPessoais;


public class DadosDTO {

    private Long id;

    @NotBlank(message = "O nome deve ser preenchido!")
    private String nome;

    @NotBlank(message = "O sobrenome deve ser preenchido!")
    private String sobrenome;

    @Min(value = 1, message = "A idade deve ser preenchida!")
    @NotNull(message = "A idade deve ser preenchida!")
    private int idade;

    @NotBlank(message = "O País deve ser preenchido!")
    private String pais;

    public DadosDTO() {
    }

    public DadosDTO(DadosPessoais dadosPessoais) {
        this.id = dadosPessoais.getId();
        this.nome = dadosPessoais.getNome();
        this.sobrenome = dadosPessoais.getSobrenome();
        this.idade = dadosPessoais.getIdade();
        this.pais = dadosPessoais.getPais();
    }

    public static DadosPessoais convert (DadosDTO dadosDTO){
        DadosPessoais dados = new DadosPessoais();
        dados.setId(dadosDTO.getId());
        dados.setNome(dadosDTO.getNome());
        dados.setSobrenome(dadosDTO.getSobrenome());
        dados.setIdade(dadosDTO.getIdade());
        dados.setPais(dadosDTO.getPais());
        return dados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
