package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FilmeDao;
import dominio.Filme;

public class FilmeDaoImpl implements FilmeDao {

	private EntityManager em;
	
	public FilmeDaoImpl() {
		this.em = EM.getLocalEm();
		
	}
	
	@Override
	public void inserirAtualizar(Filme x) {
		if(x.getCodFilme() !=null) {
			x= em.merge(x);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Filme x) {
		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Filme buscar(int cod) {
		return em.find(Filme.class, cod);
	}
	
	@SuppressWarnings("uncheked")
	@Override	
	public List<Filme> buscarTodos() {
		String jpql = "SELECT X FROM Filme x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
