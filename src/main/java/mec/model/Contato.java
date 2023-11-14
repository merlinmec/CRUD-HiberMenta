package mec.model;

public class Contato {

	private int idcon;
	private String nome;
	private String telefone;
	private String email;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
		
	public Contato() {
		super();
	}
		
	public Contato(int idcon, String nome, String telefone, String email, String rua, String numero, String bairro, String cidade, String estado) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getIdcon() {
			return idcon;
	}
	public void setIdcon(int idcon) {
			this.idcon = idcon;
	}
	public String getNome() {
			return nome;
	}
	public void setNome(String nome) {
			this.nome = nome;
	}
	public String getTelefone() {
			return telefone;
	}
	public void setTelefone(String telefone) {
			this.telefone = telefone;
	}
	public String getEmail() {
			return email;
	}
	public void setEmail(String email) {
			this.email = email;
	}
	public String getRua() {
			return rua;
	}
	public void setRua(String rua) {
			this.rua = rua;
	}
	public String getNumero() {
			return numero;
	}
	public void setNumero(String numero) {
			this.numero = numero;
	}
	public String getBairro() {
			return bairro;
	}
	public void setBairro(String bairro) {
			this.bairro = bairro;
	}
	public String getCidade() {
			return cidade;
	}
	public void setCidade(String cidade) {
			this.cidade = cidade;	
	}
	public String getEstado() {
			return estado;
	}
	public void setEstado(String estado) {
			this.estado = estado;
	}

}
	
	

