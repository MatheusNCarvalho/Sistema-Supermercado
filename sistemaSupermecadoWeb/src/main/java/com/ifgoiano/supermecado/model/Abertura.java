package com.ifgoiano.supermecado.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aberturas")

public class Abertura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_abertura")
	private long id;
	
	@Column(name="data_fechamento")
	private LocalDateTime dataFechamento;
	
	@Column(name="saldo_inicial")
	private BigDecimal saldoInicial;
	
	@Column(name="funcionario")
	private String funcionario;

	

	@Column(name="fk_movimento")
	private long fkMovimento; 
	
	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFechamento == null) ? 0 : dataFechamento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((saldoInicial == null) ? 0 : saldoInicial.hashCode());
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
		Abertura other = (Abertura) obj;
		if (dataFechamento == null) {
			if (other.dataFechamento != null)
				return false;
		} else if (!dataFechamento.equals(other.dataFechamento))
			return false;
		if (id != other.id)
			return false;
		if (saldoInicial == null) {
			if (other.saldoInicial != null)
				return false;
		} else if (!saldoInicial.equals(other.saldoInicial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Abertura [id=" + id + ", dataFechamento=" + dataFechamento + ", saldoInicial=" + saldoInicial + "]";
	}
	
	
}
