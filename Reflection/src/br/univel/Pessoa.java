package br.univel;

import br.univel.anotation.Tabela;
import br.univel.enums.EstadoCivil;

@Tabela("cad_pessoa")
public class Pessoa {
	
	//@Tabela("id") vai dar erro porque o TARGET na annotation
	private int id;
	private String nome;
	private EstadoCivil estadoCivil;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}
