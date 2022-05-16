package br.com.gerenciadorCondominio.services;

import br.com.gerenciadorCondominio.entity.Morador;
import br.com.gerenciadorCondominio.repositories.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Morador salvar(Morador morador){
        return moradorRepository.save(morador);
    }

    public List<Morador> listaMorador(){
        return moradorRepository.findAll();
    }

    public Optional<Morador> buscarPorId(Long id){
        return moradorRepository.findById(id);
    }

    public void removerPorId(Long id){
        moradorRepository.deleteById(id);
    }
}
