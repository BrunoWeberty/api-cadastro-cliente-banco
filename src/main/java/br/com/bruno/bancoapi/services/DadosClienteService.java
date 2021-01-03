package br.com.bruno.bancoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.bancoapi.entities.DadosCliente;
import br.com.bruno.bancoapi.repositories.DadosClienteRepository;

@Service
public class DadosClienteService {
	private final DadosClienteRepository dadosClienteRepository;
	
	@Autowired
	public DadosClienteService(DadosClienteRepository dadosClienteRepository) {
		this.dadosClienteRepository = dadosClienteRepository;
	}
	
	public DadosCliente save(DadosCliente dadosCliente) {
		return dadosClienteRepository.save(dadosCliente);
	}
	
	public List<DadosCliente> findAll() {
		return dadosClienteRepository.findAll();
	}
	
	public DadosCliente findById(Long id) {
		return dadosClienteRepository.findById(id).get();
	}
	
	public DadosCliente findByEmail(String email) {
		Optional<DadosCliente> obj = dadosClienteRepository.findByEmail(email);
		if(obj.isEmpty()) {
			return null;
		} else {
			return obj.get();
		}
	}
	
	public DadosCliente findByCpf(String cpf) {
		Optional<DadosCliente> obj = dadosClienteRepository.findByCpf(cpf);
		if(obj.isEmpty()) {
			return null;
		} else {
			return obj.get();
		}
	}
}
