package br.com.bruno.bancoapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.bruno.bancoapi.entities.DadosCliente;
import lombok.Getter;

@Getter
public class DadosClienteDTO {
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{email.not.blank}")
	@Email(message = "{email.not.valid}")
	private String email;
	
	@NotBlank(message = "{cpf.not.blank}")
	private String cpf;
	
	@NotBlank(message = "{dataNascimento.not.blank}")
	private String dataNascimento;
	
	public DadosCliente transformaParaObjeto() {
		return new DadosCliente(nome, email, cpf, dataNascimento);
	}
}
