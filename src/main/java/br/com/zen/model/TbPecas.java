package br.com.zen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Classe utilizada para representar uma peça do catálogo.
 */
@Entity
@Table(name = "tb_pecas")
public class TbPecas {

	@Id
	@Column(name = "ID_PECA", updatable = false, nullable = false)
	private long idPeca;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "VEICULO_APLICACAO")
	private String veiculoAplicacao;

	@Column(name = "PESO_LIQUIDO")
	private BigDecimal pesoLiquido;

	@Column(name = "PESO_BRUTO")
	private BigDecimal pesoBruto;
	
	public TbPecas() {
	}
	
	public TbPecas(String nome, String veiculoAplicacao, BigDecimal pesoLiquido, BigDecimal pesoBruto) {
		this.nome = nome;
		this.veiculoAplicacao = veiculoAplicacao;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
	}

	public long getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(long idPeca) {
		this.idPeca = idPeca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVeiculoAplicacao() {
		return veiculoAplicacao;
	}

	public void setVeiculoAplicacao(String veiculoAplicacao) {
		this.veiculoAplicacao = veiculoAplicacao;
	}

	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
}