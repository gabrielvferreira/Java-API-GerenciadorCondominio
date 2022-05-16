package br.com.gerenciadorCondominio.repositories;

import br.com.gerenciadorCondominio.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
