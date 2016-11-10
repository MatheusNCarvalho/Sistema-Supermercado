package com.ifgoiano.supermecado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name="fornecedores")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_fornecedor")
	private long idFornecedor;
	
	@NotEmpty(message="Nome é obrigatorio")
	private String nome;
	
	@NotEmpty(message="CNPJ é obrigatorio")
	@Column(unique=true)	
	private String cnpj;
	
	@NotEmpty(message="Telefone é obrigatorio")	
	private String telefone;
	
	
	@Column(name="logadouro")
	private String logradouro;
	private String bairro;
	@NotEmpty(message="Cep é obrigatorio")
	private String cep;
	
	@NotEmpty(message="cidade é obrigatoria")
	private String cidade;
	
	@NotEmpty(message="Estado é obrigatoria")
	private String estado;
	private String pais;
		
	public long getIdFornecedor() {
	
		return idFornecedor;
	}
	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		
		//this.nome = nome.toLowerCase();
		this.nome  = nome;		
	}
	
	public void setCnpj(String cnpj) {		
		
		this.cnpj = cnpj;
	
	}
	
	public String getCnpj() {
		
		
		return cnpj ;
		
	}
	
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFornecedor ^ (idFornecedor >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (idFornecedor != other.idFornecedor)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nome=" + nome + ", cnpj=" + cnpj + "]";
	}
	
	
}
