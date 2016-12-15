package com.ifgoiano.supermecado.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="vendas_itens")
public class ItemVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_item")
	private long idItem;
	
	@Column(name="qtd")
	private Integer qtd;

	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name="fk_venda",referencedColumnName="pk_venda", insertable=false, updatable=false)
	private Venda venda;
	
	@Column(name="fk_venda")
	private long fkVenda;
	
	@ManyToOne
	@JoinColumn(name="fk_produto",referencedColumnName="pk_produtos", insertable=false, updatable=false)
	private Produto produto;
	
	@Column(name="fk_produto")
	private int fkProduto;
	
	@Transient
	private BigDecimal valorTotal;

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getFkProduto() {
		return fkProduto;
	}

	public void setFkProduto(int fkProduto) {
		this.fkProduto = fkProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fkProduto;
		result = prime * result + (int) (fkVenda ^ (fkVenda >>> 32));
		result = prime * result + (int) (idItem ^ (idItem >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtd == null) ? 0 : qtd.hashCode());
		result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
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
		ItemVenda other = (ItemVenda) obj;
		if (fkProduto != other.fkProduto)
			return false;
		if (fkVenda != other.fkVenda)
			return false;
		if (idItem != other.idItem)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtd == null) {
			if (other.qtd != null)
				return false;
		} else if (!qtd.equals(other.qtd))
			return false;
		if (valorUnitario == null) {
			if (other.valorUnitario != null)
				return false;
		} else if (!valorUnitario.equals(other.valorUnitario))
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
		return "ItemVenda [idItem=" + idItem + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", venda=" + venda
				+ ", fkVenda=" + fkVenda + ", produto=" + produto + ", fkProduto=" + fkProduto + "]";
	}
	
	
	
}
