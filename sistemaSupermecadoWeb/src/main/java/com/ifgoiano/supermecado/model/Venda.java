package com.ifgoiano.supermecado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="vendas")
public class Venda {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="pk_venda")
private long idVenda;


@Column(name = "data_hora")
private String dataVenda;

private String usuario;



public String getUsuario() {
	return usuario;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public long getIdVenda() {
	return idVenda;
}


public void setIdVenda(long idVenda) {
	this.idVenda = idVenda;
}


public String getDataVenda() {
	return dataVenda;
}


public void setDataVenda(String dataVenda) {
	this.dataVenda = dataVenda;
}


@Override
public String toString() {
	return "Venda [idVenda=" + idVenda + ", dataVenda=" + dataVenda + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
	result = prime * result + (int) (idVenda ^ (idVenda >>> 32));
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
	Venda other = (Venda) obj;
	if (dataVenda == null) {
		if (other.dataVenda != null)
			return false;
	} else if (!dataVenda.equals(other.dataVenda))
		return false;
	if (idVenda != other.idVenda)
		return false;
	return true;
}












}

