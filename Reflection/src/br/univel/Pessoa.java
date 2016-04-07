package br.univel;

import br.univel.anotation.Tabela;

@Tabela("cad_pessoa")
public class Pessoa {
	
	//@Tabela("id") vai dar erro porque o TARGET na annotation
	private int id;
	private String nome;
	
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
}
