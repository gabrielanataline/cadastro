package com.itau.estagiaria.controllers;
import com.itau.estagiaria.models.dtos.DadosDTO;
import com.itau.estagiaria.services.DadosService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DadosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DadosController.class);


    @Autowired
    private DadosService dadosService;

    @PostMapping("/dados")
    public DadosDTO save(@RequestBody @Valid DadosDTO dto){
        try{
            LOGGER.info("Cadastro criado com sucesso!");
            return this.dadosService.save(dto);
        } catch (RuntimeException e) {
            LOGGER.error("Erro ao criar cadastro!");
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/dados")
    public List<DadosDTO> findAll() {
        return this.dadosService.findAll();
    }

    @GetMapping("/dados/{id}")
    public DadosDTO findById(@PathVariable Long id){
        return this.dadosService.findById(id);
    }

    @PutMapping("/dados/{id}")
    public DadosDTO updateById(@PathVariable Long id, @RequestBody @Valid DadosDTO dto){
        return this.dadosService.updateById(id, dto);
    }

    @DeleteMapping("/dados/{id}")
    public DadosDTO deleteById(@PathVariable Long id){
        return this.dadosService.deleteById(id);
    }
}
