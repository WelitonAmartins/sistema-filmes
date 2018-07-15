package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;
	
	public ArtistaDaoImpl() {
		this.em = EM.getLocalEm();
		
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		if(x.getCodArtista() !=null) {
			x= em.merge(x);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}
	
	@SuppressWarnings("uncheked")
	@Override	
	public List<Artista> buscarTodos() {
		String jpql = "SELECT X FROM Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
