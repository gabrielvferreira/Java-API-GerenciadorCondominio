package br.com.condominio.condominio.controller;

import br.com.condominio.condominio.entity.Morador;
import br.com.condominio.condominio.services.MoradorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/morador")
public class CadastroMoradorController {

    @Autowired
    private MoradorService moradorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Morador salvar(@RequestBody Morador morador){
        return moradorService.salvar(morador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Morador> listaMorador(){
        return moradorService.listaMorador();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Morador buscarMoradorPorId(@PathVariable Long id){
        return moradorService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Morador nao encontrado"));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMorador(@PathVariable Long id){
        moradorService.buscarPorId(id)
                .map(cliente -> {
                    moradorService.removerPorId(cliente.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Morador nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarMorador(@PathVariable Long id, @RequestBody Morador morador){
        moradorService.buscarPorId(id)
                .map(moradorBase -> {
                    modelMapper.map(morador, moradorBase);
                    moradorService.salvar(moradorBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Morador nao encontrado"));
    }
}
