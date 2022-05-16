package br.com.condominio.condominio.repositories;

import br.com.condominio.condominio.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    //Optional<Agenda> findBYData(Date data);

    //List<Agenda> findAllByArea(String areaDeServico);

}
