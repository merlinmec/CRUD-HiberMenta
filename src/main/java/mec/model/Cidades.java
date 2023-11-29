package mec.model;

public class Cidades {
	
	private int id;
	private String nome;
	private Estados estado;
	
	public Cidades() {
		super();
	}
	
	public Cidades(int id, String nome, Estados estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		
	}

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

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
}
