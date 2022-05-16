package br.com.condominio.condominio.services;


import br.com.condominio.condominio.entity.Agenda;
import br.com.condominio.condominio.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> listarAgenda(){
        return agendaRepository.findAll();
    }

    public Agenda salvar(Agenda agenda){
        return agendaRepository.save(agenda);
    }

    public Optional<Agenda> buscarPorId(Long id){
        return agendaRepository.findById(id);
    }

    public void removerPorId(Long id){
        agendaRepository.deleteById(id);
    }
}
