package com.itau.estagiaria.services;

import com.itau.estagiaria.models.DadosPessoais;
import com.itau.estagiaria.models.dtos.DadosDTO;
import com.itau.estagiaria.repositories.DadosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DadosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DadosService.class);

    @Autowired
    private DadosRepository dadosRepository;

    public DadosDTO save (DadosDTO dto){
        LOGGER.info("Dados salvos com sucesso!");
        DadosPessoais dados = DadosDTO.convert(dto);
        dados = this.dadosRepository.save(dados);
        return new DadosDTO(dados);
    }

    public List<DadosDTO> findAll(){
        LOGGER.info("Busca realizada com sucesso!");
        List<DadosPessoais> dados = this.dadosRepository.findAll();
        return dados.stream().map(DadosDTO::new).collect(Collectors.toList());
    }

    public DadosDTO findById(Long id) {
        Optional<DadosPessoais> resultado = this.dadosRepository.findById(id);
        if (resultado.isPresent()) {
            LOGGER.info("Dados com id {} encontrados com sucesso!", id);
            return new DadosDTO(resultado.get());
        } else {
            LOGGER.error("O id informado não foi encontrado: {}", id);
            throw new RuntimeException("O id informado não foi encontrado!");
        }
    }

    public DadosDTO updateById(Long id, DadosDTO dto) {
        DadosDTO existingDto = this.findById(id);
        if (existingDto != null) {
            DadosPessoais dadosPessoais = DadosDTO.convert(dto);
            dadosPessoais.setId(id);
            dadosPessoais = this.dadosRepository.save(dadosPessoais);
            LOGGER.info("Dados com id {} atualizados com sucesso!", id);
            return new DadosDTO(dadosPessoais);
        } else {
            LOGGER.error("Cadastro não encontrado com o id {}", id);
            throw new RuntimeException("Cadastro não encontrado com o id " + id);
        }
    }

    public DadosDTO deleteById(Long id) {
        DadosDTO dto = this.findById(id);
        if (dto != null) {
            this.dadosRepository.deleteById(id);
            LOGGER.info("Dados com id {} excluídos com sucesso!", id);
        } else {
            LOGGER.error("Cadastro não encontrado com o id {}", id);
            throw new RuntimeException("Cadastro não encontrado com o id " + id);
        }
        return dto;
    }

}
