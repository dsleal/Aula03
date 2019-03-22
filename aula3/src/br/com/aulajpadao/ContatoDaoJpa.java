package br.com.aulajpadao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.com.aulajpa.Contato;

public class ContatoDaoJpa {
	public void incluir(Contato contato) {
		EntityManager em = ConexaoJpa.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(contato);
		tx.commit();
		em.close();
	}

	public void alterar(Contato contato) {
		EntityManager em = ConexaoJpa.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contato);
		tx.commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = ConexaoJpa.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Contato contato = em.find(Contato.class, id);
		em.remove(contato);
		tx.commit();
		em.close();
	}

	public Contato consultar(int id) {
		EntityManager em = ConexaoJpa.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Contato contato = em.find(Contato.class, id);
		em.close();
		return contato;
	}

	public List<Contato> listar() {
		EntityManager em = ConexaoJpa.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query query = em.createQuery("select c from Contato c");
		List<Contato> lista = query.getResultList();
		em.close();

		return lista;
	}
}