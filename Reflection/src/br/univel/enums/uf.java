package br.univel.enums;

public enum uf {
	PR(1, "Parana"),
	SC(2, "Santa Catarina"),
	RS(3, "Rio Grande Do Sul");
	
	private int id;
	private String nome;
	
	private uf(int _id, String _nome){
		this.id = _id;
		this.nome = _nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
