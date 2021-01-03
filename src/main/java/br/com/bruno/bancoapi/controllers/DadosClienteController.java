package br.com.bruno.bancoapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.bancoapi.dto.DadosClienteDTO;
import br.com.bruno.bancoapi.dto.DadosClienteRespostaDTO;
import br.com.bruno.bancoapi.entities.DadosCliente;
import br.com.bruno.bancoapi.services.DadosClienteService;

@RestController
@RequestMapping("/clientes")
public class DadosClienteController {
	
	private final DadosClienteService dadosClienteService;
	
	@Autowired
	public DadosClienteController(DadosClienteService dadosClienteService) {
		this.dadosClienteService = dadosClienteService;
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> adicionarCliente(@RequestBody @Valid DadosClienteDTO dto) {
		String message;
		if(dadosClienteService.findByCpf(dto.getCpf()) != null && dadosClienteService.findByEmail(dto.getEmail()) != null) {
			message = "Já existe um cliente cadastrado com esse CPF e E-mail! ";
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		} else if(dadosClienteService.findByCpf(dto.getCpf()) != null) {
			message = "Já existe um cliente cadastrado com esse CPF!";
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		} else if(dadosClienteService.findByEmail(dto.getEmail()) != null) {
			message = "Já existe um cliente cadastrado com esse E-mail!";
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		DadosCliente dadosCliente = dadosClienteService.save(dto.transformaParaObjeto());	
        return new ResponseEntity<>(DadosClienteRespostaDTO.transformaEmDTO(dadosCliente), HttpStatus.CREATED);     
	}
	
	@GetMapping
	public ResponseEntity<List<DadosCliente>> listaClientes() {
		return ResponseEntity.ok().body(dadosClienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosCliente> buscaPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(dadosClienteService.findById(id));
	}
}
