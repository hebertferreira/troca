package troca.modelo;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import troca.hibernate.Entidade;

@Entity
public class Proposta implements Entidade {

	@Id
	@GeneratedValue
	private Integer id;

	private BigDecimal valor;

	private GregorianCalendar validadeProposta;
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produtoLeiloado;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario comprador;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario vendedor;

	private String statusProposta;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "proposta_produto", joinColumns = { @JoinColumn(name = "proposta_id") }, inverseJoinColumns = { @JoinColumn(name = "produto_id") })
	private List<Produto> produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public GregorianCalendar getValidadeProposta() {
		return validadeProposta;
	}

	public void setValidadeProposta(GregorianCalendar validadeProposta) {
		this.validadeProposta = validadeProposta;
	}

	public Produto getProdutoLeiloado() {
		return produtoLeiloado;
	}

	public void setProdutoLeiloado(Produto produtoLeiloado) {
		this.produtoLeiloado = produtoLeiloado;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getStatusProposta() {
		return statusProposta;
	}

	public void setStatusProposta(String statusProposta) {
		this.statusProposta = statusProposta;
	}
}
