package br.com.condominio.condominio.repositories;

import br.com.condominio.condominio.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
