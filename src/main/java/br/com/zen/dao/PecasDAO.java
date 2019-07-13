package br.com.zen.dao;

import java.util.List;
import br.com.zen.model.TbPecas;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a entity TbPecas.
 */
public interface PecasDAO {
	public void salvarPeca(TbPecas tbPeca);

	public void atualizarPeca(TbPecas tbPeca);
	
	public void removerPeca(TbPecas tbPeca);
	
	public List<TbPecas> getTodasPecas();
	
	public TbPecas getPecaById(long idPeca);
}
