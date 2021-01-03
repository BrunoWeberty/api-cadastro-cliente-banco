package br.com.bruno.bancoapi.dto;

import java.util.Date;

import br.com.bruno.bancoapi.entities.DadosCliente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DadosClienteRespostaDTO {
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	
	public static DadosClienteRespostaDTO transformaEmDTO(DadosCliente dadosCliente) {
		return new DadosClienteRespostaDTO(dadosCliente.getId(), dadosCliente.getNome(), dadosCliente.getEmail(), dadosCliente.getCpf(), dadosCliente.getDataNascimento());
	}
}
