package com.ifgoiano.supermecado.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="vendas")
public class Venda {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="pk_venda")
private long idVenda;


@Column(name="fk_abertura")
private int fkAbertura;

@ManyToOne
@JoinColumn(name="fk_cliente",referencedColumnName="pk_cliente", insertable=false, updatable=false)
private Cliente cliente;

@Column(name="fk_cliente")
private int fkCliente;

@Column(name = "data_hora")
private String dataVenda;

private String usuario;



public long getFkAbertura() {
	return fkAbertura;
}


public void setFkAbertura(int fkAbertura) {
	this.fkAbertura = fkAbertura;
}


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


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


public int getFkCliente() {
	return fkCliente;
}


public void setFkCliente(int fkCliente) {
	this.fkCliente = fkCliente;
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

public String getDateTime(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date data = new Date();
	return dateFormat.format(data);
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

