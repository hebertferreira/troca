package troca.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import troca.hibernate.Entidade;

@Entity
public class Proposta implements Entidade {

	@Id
	@GeneratedValue
	private Integer id;

	private BigDecimal valor;

	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produtoLeiloado;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario comprador;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario vendedor;

	//@manytomany()
	//private List<Produto> produtosDeTroca;

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

}
