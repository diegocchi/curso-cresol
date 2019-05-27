package br.com.cresol.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.cresol.model.Abastecimento;
import br.com.cresol.model.Usuario;

@LocalBean
@Stateless
public class AbastecimentoDAO extends AbstractDAO {

	public Abastecimento inserir(Abastecimento obj) throws Exception {
		getEntityManager().persist(obj);
		getEntityManager().flush();
		return obj;
	}
	
	
	public Abastecimento alterar(Abastecimento obj)throws Exception {
		Abastecimento old = getEntityManager().find(Abastecimento.class, obj.getId());
		getEntityManager().merge(obj);
		getEntityManager().flush();
		return obj;
	}
	
	public Abastecimento buscar(Long id) throws Exception {
		return getEntityManager().find(Abastecimento.class, id);
	}
	
	public void remover(Long id)throws Exception {
		Abastecimento obj = buscar(id);
		getEntityManager().remove(obj);
		getEntityManager().flush();
	}
	
    public List<Abastecimento> buscarTodos() throws Exception {         
        try { 
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Abastecimento.class));
            Query q = entityManager.createQuery(cq);            
            return q.getResultList();
        } finally {
        }
    }
	
}
