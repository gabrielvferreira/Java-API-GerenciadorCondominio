package br.com.condominio.condominio.controller;

import br.com.condominio.condominio.entity.Agenda;
import br.com.condominio.condominio.services.AgendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/agenda")
public class GerenciadorAgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda salvar(@RequestBody Agenda agenda){
        return agendaService.salvar(agenda);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Agenda> listaAgenda(){
        return agendaService.listarAgenda();
    }

 /*   @GetMapping("/{areaDeServico}")
    @ResponseStatus(HttpStatus.OK)
    public List<Agenda> listaAgendaPorAreaDeServico(@PathVariable String areaDeServico){
        return agendaService.listaAgendaPorAreaDeServico(areaDeServico);
    }*/

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agenda buscarAgendamentoPorId(@PathVariable Long id){
        return agendaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento nao encontrado"));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAgendamento(@PathVariable Long id){
        agendaService.buscarPorId(id)
                .map(cliente -> {
                    agendaService.removerPorId(cliente.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAgendamento(@PathVariable Long id, @RequestBody Agenda agenda){
        agendaService.buscarPorId(id)
                .map(agendaBase -> {
                    modelMapper.map(agenda, agendaBase);
                    agendaService.salvar(agendaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento nao encontrado"));
    }
}
