package br.com.bruno.bancoapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.bancoapi.entities.DadosCliente;

@Repository
public interface DadosClienteRepository extends JpaRepository<DadosCliente, Long>{
	
	Optional<DadosCliente> findByCpf(String cpf);
	Optional<DadosCliente> findByEmail(String email);
}
