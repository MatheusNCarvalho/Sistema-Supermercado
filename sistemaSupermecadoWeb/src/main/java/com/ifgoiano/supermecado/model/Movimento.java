package com.ifgoiano.supermecado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimentos")
public class Movimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_movimento")
	private long idMovimento;
	

	@ManyToOne
	@JoinColumn(name="fk_abertura",referencedColumnName="pk_abertura", insertable=false, updatable=false)
	private Abertura abertura;
	
	@Column(name="fk_abertura")
	private int fkAbertura;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="valor")
	private Double valor;

	public long getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Abertura getAbertura() {
		return abertura;
	}

	public void setAbertura(Abertura abertura) {
		this.abertura = abertura;
	}

	public int getFkAbertura() {
		return fkAbertura;
	}

	public void setFkAbertura(int fkAbertura) {
		this.fkAbertura = fkAbertura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abertura == null) ? 0 : abertura.hashCode());
		result = prime * result + fkAbertura;
		result = prime * result + (int) (idMovimento ^ (idMovimento >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Movimento other = (Movimento) obj;
		if (abertura == null) {
			if (other.abertura != null)
				return false;
		} else if (!abertura.equals(other.abertura))
			return false;
		if (fkAbertura != other.fkAbertura)
			return false;
		if (idMovimento != other.idMovimento)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movimentacao [idMovimento=" + idMovimento + ", abertura=" + abertura + ", fkAbertura=" + fkAbertura
				+ ", tipo=" + tipo + ", valor=" + valor + "]";
	}
	
}
