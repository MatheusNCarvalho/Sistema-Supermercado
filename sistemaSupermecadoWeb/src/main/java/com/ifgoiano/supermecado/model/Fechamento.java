package com.ifgoiano.supermecado.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fechamentos")

public class Fechamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_fechamento")
	private long id;
	
	private int fkAbertura;
	
	private LocalDateTime data_fechamento;
	
	private BigDecimal saldoFinal;
	
	private String Funcionario;
	
	public int getFkAbertura() {
		return fkAbertura;
	}

	public void setFkAbertura(int fkAbertura) {
		this.fkAbertura = fkAbertura;
	}

	public BigDecimal getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(BigDecimal saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public String getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(String funcionario) {
		Funcionario = funcionario;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getFk_abertura() {
		return fkAbertura;
	}
	
	public void setFk_abertura(int fk_abertura) {
		this.fkAbertura = fk_abertura;
	}
	
	public LocalDateTime getData_fechamento() {
		return data_fechamento;
	}
	
	public void setData_fechamento(LocalDateTime data_fechamento) {
		this.data_fechamento = data_fechamento;
	}
	
	public BigDecimal getSaldo_final() {
		return saldoFinal;
	}
	
	public void setSaldo_final(BigDecimal saldo_final) {
		this.saldoFinal = saldo_final;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Fechamento other = (Fechamento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fechamento [id=" + id + ", fkAbertura=" + fkAbertura + ", data_fechamento=" + data_fechamento
				+ ", saldoFinal=" + saldoFinal + "]";
	}
	
}