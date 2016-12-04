package com.ifgoiano.supermecado.model;





import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;







@Entity
@Table(name="compras")
public class Compra {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="pk_compra")
		private long idCompra;
	  
		@Column(name = "data_hora")
		private Date dataCompra;
		
		@ManyToOne
		@JoinColumn(name="fk_fornecedor",referencedColumnName="pk_fornecedor", insertable=false, updatable=false)
		private Fornecedor fornecedor;
		
		@Column(name="fk_fornecedor")
		private int fkFornecedor;
		
		private String usuario;

		public Date getDataCompra() {
			return dataCompra;
		}

		public void setDataCompra(Date dataCompra) {
			this.dataCompra = dataCompra;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public int getFkFornecedor() {
			return fkFornecedor;
		}

		public void setFkFornecedor(int fkFornecedor) {
			this.fkFornecedor = fkFornecedor;
		}

		@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
		private List<ItemCompra> itens = new ArrayList<>();

		public long getIdCompra() {
			return idCompra;
		}

		public void setIdCompra(long idCompra) {
			this.idCompra = idCompra;
		}

		

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}

		public List<ItemCompra> getItens() {
			return itens;
		}

		public void setItens(List<ItemCompra> itens) {
			this.itens = itens;
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
			result = prime * result + (int) (idCompra ^ (idCompra >>> 32));
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
			Compra other = (Compra) obj;
			if (idCompra != other.idCompra)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Compra [idCompra=" + idCompra + ", dataCompra=" + ", fornecedor=" + fornecedor
					+ ", fkFornecedor=" + fkFornecedor + ", itens=" + itens + "]";
		}
		
		
		

}
