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

@Entity
@Table(name="compras_itens")
public class ItemCompra {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="pk_item")
		private long idItem;
		
		@Column(name="qtd")
		private Integer qtd;
		
		@Column(name="valor_unitario")
		private BigDecimal valorUnitario;
		
		@ManyToOne
		@JoinColumn(name="fk_compra",referencedColumnName="pk_compra", insertable=false, updatable=false)
		private Compra compra;
		
		@Column(name="fk_compra")
		private long fkCompra;
		
		@ManyToOne
		@JoinColumn(name="fk_produto",referencedColumnName="pk_produtos", insertable=false, updatable=false)
		private Produto produto;
		
		@Column(name="fk_produto")
		private int fkProduto;
		
		
		
		public long getIdItem() {
			return idItem;
		}

		public void setIdItem(long idItem) {
			this.idItem = idItem;
		}

		public Integer getQtd() {
			return qtd;
		}

		public long getFkCompra() {
			return fkCompra;
		}

		public void setFkCompra(long fkCompra) {
			this.fkCompra = fkCompra;
		}

		public int getFkProduto() {
			return fkProduto;
		}

		public void setFkProduto(int fkProduto) {
			this.fkProduto = fkProduto;
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

		public Compra getCompra() {
			return compra;
		}

		public void setCompra(Compra compra) {
			this.compra = compra;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (idItem ^ (idItem >>> 32));
			return result;
		}

		

		@Override
		public String toString() {
			return "ItemCompra [idItem=" + idItem + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", compra="
					+ compra + ", fkCompra=" + fkCompra + ", produto=" + produto + ", fkProduto=" + fkProduto + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemCompra other = (ItemCompra) obj;
			if (idItem != other.idItem)
				return false;
			return true;
		}
		
		
	
	

}
