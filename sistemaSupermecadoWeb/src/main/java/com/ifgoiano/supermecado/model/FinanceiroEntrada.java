package com.ifgoiano.supermecado.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

@Entity
@Table(name="financeiros_entradas")
public class FinanceiroEntrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_financeiro")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="fk_venda",referencedColumnName="pk_venda", insertable=false, updatable=false)
	private Venda venda;
	
	@Column(name="fk_venda")
	private long fkVenda;
	
	@Column(name="data_emissao")
	private Date dataEmissao;
	
	@Column(name="data_vencimento")
	private Date dataVencimento;
	
	@Column(name="data_baixa")
	private Date dataBaixa;
	
	@Column(name="valor")
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public long getFkVenda() {
		return fkVenda;
	}

	public void setFkVenda(long fkVenda) {
		this.fkVenda = fkVenda;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataSistemaDate) {
		this.dataEmissao = dataSistemaDate;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataSistemaDate) {
		this.dataVencimento = dataSistemaDate;
	}

	public Date getDataBaixa() {
		return dataBaixa;
	}	

	public void setDataBaixa(Date dataSistemaDate) {
		this.dataBaixa = dataSistemaDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataBaixa == null) ? 0 : dataBaixa.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
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
		FinanceiroEntrada other = (FinanceiroEntrada) obj;
		if (dataBaixa == null) {
			if (other.dataBaixa != null)
				return false;
		} else if (!dataBaixa.equals(other.dataBaixa))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (fkVenda != other.fkVenda)
			return false;
		if (id != other.id)
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanceiroEntrada [id=" + id + ", venda=" + venda + ", fkVenda=" + fkVenda + ", dataEmissao="
				+ dataEmissao + ", dataVencimento=" + dataVencimento + ", dataBaixa=" + dataBaixa + "]";
	}

	
}
