package com.itau.estagiaria.repositories;

import com.itau.estagiaria.models.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosRepository extends JpaRepository <DadosPessoais, Long> {

    List<DadosPessoais> findByIdade(int idade);

    @Query("SELECT d FROM DadosPessoais d WHERE d.idade > :idadeMinima")
    List<DadosPessoais> findByMinAge(int idadeMinima);

    List<DadosPessoais> findByPais(String pais);


}
