package br.com.zen.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.zen.dao.PecasDAOImpl;
import br.com.zen.model.TbPecas;

/**
 * Classe utilizada para fazer receber as informações das views.
 */
@ManagedBean(name = "pecasBean")
public class PecasBean {
	
	//private static final Logger logger = LogManager.getLogger(PecasBean.class);

	private int idPeca;
	private String nome;
	private String veiculoAplicacao;
	private BigDecimal pesoLiquido;
	private BigDecimal pesoBruto;
	private List<TbPecas> pecas;

	private PecasDAOImpl pecasDAO = new PecasDAOImpl();

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
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

	public List<TbPecas> getPecas() {
		pecas = pecasDAO.getTodasPecas();
		return pecas;
	}

	public void setPecas(List<TbPecas> pecas) {
		this.pecas = pecas;
	}

	// Salvar uma nova peca
	public void salvarPeca() {
		try {

			TbPecas pecaNova = new TbPecas();

			pecaNova.setNome(nome);
			pecaNova.setVeiculoAplicacao(veiculoAplicacao);
			pecaNova.setPesoLiquido(pesoLiquido);
			pecaNova.setPesoBruto(pesoBruto);

			// Novas peças tem que ter peso líquido < peso bruto
			if (pesoLiquido.doubleValue() < pesoBruto.doubleValue()) {
				System.out.println("Peso Líquido é menor que Peso Bruto.");
				//logger.info("Peso Líquido é menor que Peso Bruto.");

				pecasDAO.salvarPeca(pecaNova);
				//LimparCampos();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cadastro da nova peça realizado com sucesso", "Sucesso."));			
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Peso Líquido deve ser menor que Peso Bruto. ", "Erro."));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Ocorreu um erro ao tentar cadastrar uma nova peça.", "Erro ao cadastrar."));
			//logger.error("Ocorreu um erro ao tentar cadastrar uma nova peça.");
			e.printStackTrace();
		}
	}

	// Remover uma peca da tabela
	public void removerPeca(TbPecas removerPeca) {
		try {

			this.pecasDAO.removerPeca(removerPeca);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Peça " + removerPeca.getNome() + " foi removida com sucesso.", "Sucesso."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Ocorreu um erro ao tentar remover a peça.", "Erro ao remover."));
			//logger.error("Ocorreu um erro ao tentar remover uma peça.");
			e.printStackTrace();
		}
	}

	// Método para limpar os valores da tela de cadastro de pecas
	public void LimparCampos() {
		setNome(null);
		setVeiculoAplicacao(null);
		setPesoLiquido(null);
		setPesoBruto(null);
	}
}
