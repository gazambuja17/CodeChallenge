package br.com.zen.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zen.model.TbPecas;

/**
 * Classe utilizada para fazer realizar as opera��es de banco de dados sobre a
 * entity TbPecas.
 */
@Stateless
public class PecasDAOImpl implements PecasDAO {

	EntityManagerFactory emf;
	EntityManager manager;

	public PecasDAOImpl() {
		emf = Persistence.createEntityManagerFactory("conexao");
		manager = emf.createEntityManager();
	}

	/**
	 * M�todo utilizado para salvar as informa��es de uma pe�a.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void salvarPeca(TbPecas tbPeca) {
		System.out.println("Salvando uma nova pe�a.");
		try {
			manager.getTransaction().begin();
			manager.persist(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * M�todo utilizado para atualizar as informa��es de uma pe�a.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void atualizarPeca(TbPecas tbPeca) {
		System.out.println("Atualizando uma nova pe�a.");
		try {
			manager.getTransaction().begin();
			manager.merge(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo utilizado para apagar/remover uma pe�a.
	 * 
	 * @param peca
	 * @throws java.lang.Exception
	 */
	@Override
	public void removerPeca(TbPecas tbPeca) {
		System.out.println("Removendo a pe�a com nome: " + tbPeca.getNome());
		try {
			manager.getTransaction().begin();
			manager.remove(tbPeca);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo utilizado para listar todas as pe�as do cat�logo.
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
	 * M�todo utilizado para consutar uma pe�a pelo ID.
	 * 
	 * @param id
	 * @return peca
	 */
	@Override
	public TbPecas getPecaById(long idPeca) {
		return manager.find(TbPecas.class, idPeca);
	}
}
