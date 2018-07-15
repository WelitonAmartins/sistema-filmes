package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipacaoDao;
import dominio.Participacao;

public class ParticipacaoDaoImpl implements ParticipacaoDao {

	private EntityManager em;
	
	public ParticipacaoDaoImpl() {
		this.em = EM.getLocalEm();
		
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		if(x.getCodPartipacao() !=null) {
			x= em.merge(x);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Participacao buscar(int cod) {
		return em.find(Participacao.class, cod);
	}
	
	@SuppressWarnings("uncheked")
	@Override	
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT X FROM Participacao x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
