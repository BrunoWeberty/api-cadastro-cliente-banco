package br.com.bruno.bancoapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.bruno.bancoapi.utilities.Utilidades;
import lombok.Data;
import lombok.Getter;

@Entity
@Table
@Data
@Getter
public class DadosCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private Date dataNascimento;
	
	public DadosCliente() {}
	
	public DadosCliente(String nome, String email, String cpf, String dataNascimento) {
		Utilidades u = new Utilidades();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = u.formatarData(dataNascimento);
    }
}
