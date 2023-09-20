package com.itau.estagiaria.controllers;
import com.itau.estagiaria.models.dtos.DadosDTO;
import com.itau.estagiaria.valida.DadosResponse;
import com.itau.estagiaria.services.DadosService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DadosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DadosController.class);

    @Autowired
    private DadosService dadosService;

    @GetMapping("/")
    public ResponseEntity checkDadosStatus(){
        DadosResponse dadosResponse = new DadosResponse("Api de Cadastro iniciado com sucesso!");
        return new ResponseEntity(dadosResponse, HttpStatus.OK);
    }


    @PostMapping("/dados")
    public DadosDTO save(@RequestBody @Valid DadosDTO dto){
        return this.dadosService.save(dto);
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
