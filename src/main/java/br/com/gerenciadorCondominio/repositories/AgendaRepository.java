package br.com.gerenciadorCondominio.repositories;

import br.com.gerenciadorCondominio.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    //Optional<Agenda> findBYData(Date data);

    //List<Agenda> findAllByArea(String areaDeServico);

}
