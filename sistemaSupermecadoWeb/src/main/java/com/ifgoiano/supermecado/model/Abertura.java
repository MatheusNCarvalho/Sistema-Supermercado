package com.ifgoiano.supermecado.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
	

	private BigDecimal saldo;
	
	@Column(name="funcionario")
	private String funcionario;

	@Column(name = "data_hora")
	private Date dataVenda;

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date date) {
		this.dataVenda = date;
	}

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
	
	public String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date data = new Date();
		return dateFormat.format(data);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
		
		if (id != other.id)
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Abertura [id=" + id + ", saldo=" + saldo + ", funcionario=" + funcionario + "]";
	}

	
	
	
}
