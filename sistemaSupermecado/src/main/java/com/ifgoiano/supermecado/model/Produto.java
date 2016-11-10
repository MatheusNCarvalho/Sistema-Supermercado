package com.ifgoiano.supermecado.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produtos")

public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pk_produtos")
	private long id;
	
	@NotEmpty(message="Codigo de barras é obrigatório !")
	@NotNull(message="Codigo de barras é obrigatório !")
	@Column(name = "codigo_barras")
	private String codigoBarras;
	
	@NotNull(message="Nome do produto é obrigatório !")
	@NotEmpty(message="Nome do produto é obrigatório !")
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;
	
	@NotNull(message="O tipo da medida é obrigatório !")
	@Column(name = "tipo_medida")
	private String tipoMedida;
	
	@Column(name="qtd_Estoque")
	private BigDecimal qtdEstoque;
	
	@NotNull(message="A quantidade medida é obrigatória !")
	@Column(name= "qtd_medida")
	private BigDecimal qtdMedida;
	
	
	@NotNull(message="A quantidade maxima e obrigatória !")
	@Column(name = "qtd_maxima")
	private BigDecimal qtdMaxima;
	
	@NotNull(message="A quantidade minima e obrigatória !")
	@Column(name = "qtd_minimo")
	private BigDecimal qtdMinimo;
	
	
	@Column(name = "fk_categoria")
	private int idCategoria ;

	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	@JoinColumn(name = "fk_categoria", referencedColumnName="pk_categoria", insertable=false, updatable=false)
	private Categoria categoria;
	
	public BigDecimal getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(BigDecimal qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public BigDecimal getQtdMedida() {
		return qtdMedida;
	}

	public void setQtdMedida(BigDecimal qtdMedida) {
		this.qtdMedida = qtdMedida;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public BigDecimal getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(BigDecimal qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	

	public BigDecimal getQtdMinimo() {
		return qtdMinimo;
	}

	public void setQtdMinimo(BigDecimal qtdMinimo) {
		this.qtdMinimo = qtdMinimo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigoBarras=" + codigoBarras + ", nome=" + nome + ", valorUnitario="
				+ valorUnitario + ", qtdEstoque=" + qtdMaxima + ", qtdMinimo=" + qtdMinimo + ", idCategoria="
				+ idCategoria + "]";
	}
	
		

}
