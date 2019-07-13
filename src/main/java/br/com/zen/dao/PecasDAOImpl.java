package br.com.zen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zen.model.TbPecas;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a
 * entity TbPecas.
 */
@Stateless
public class PecasDAOImpl implements PecasDAO {
	
	//private static final Logger logger = LogManager.getLogger(PecasDAOImpl.class);

	EntityManagerFactory emf;
	EntityManager manager;

	public PecasDAOImpl() {
		emf = Persistence.createEntityManagerFactory("conexao");
		manager = emf.createEntityManager();
	}

	/**
	 * Método utilizado para salvar as informações de uma peça.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void salvarPeca(TbPecas tbPeca) {
		System.out.println("Salvando uma nova peça.");
		//logger.info("Salvando uma nova peça.");
		
		try {
			manager.getTransaction().begin();
			manager.persist(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			//logger.error("Não foi possível salvar uma nova peça.");
			e.printStackTrace();
		}	
	}

	/**
	 * Método utilizado para atualizar as informações de uma peça.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void atualizarPeca(TbPecas tbPeca) {
		System.out.println("Atualizando uma nova peça.");
		//logger.info(""Atualizando uma nova peça."");
		try {
			manager.getTransaction().begin();
			manager.merge(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			//logger.error("Não foi possível atualizar uma nova peça.");
			e.printStackTrace();
		}
	}

	/**
	 * Método utilizado para apagar/remover uma peça.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void removerPeca(TbPecas tbPeca) {
		System.out.println("Removendo a peça com nome: " + tbPeca.getNome());
		//logger.info(""Removendo a peça com nome: " + tbPeca.getNome()");
		try {
			manager.getTransaction().begin();
			manager.remove(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			//logger.error("Não foi possível remover uma peça.");
			e.printStackTrace();
		}
	}

	/**
	 * Método utilizado para listar todas as peças do catálogo.
	 * 
	 * @param peca
	 * @return todas pecas do banco
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TbPecas> getTodasPecas() {
		Query query = manager.createQuery("SELECT t FROM TbPecas t ORDER BY nome ASC");
		return query.getResultList();
	}

	/**
	 * Método utilizado para consutar uma peça pelo ID.
	 * 
	 * @param id
	 * @return peca
	 */
	@Override
	public TbPecas getPecaById(long idPeca) {
		return manager.find(TbPecas.class, idPeca);
	}
}
