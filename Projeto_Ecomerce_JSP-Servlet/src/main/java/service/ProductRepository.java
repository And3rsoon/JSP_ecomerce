package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.Products;

public class ProductRepository {

	public EntityManager getEM() {
		EntityManager em=Persistence.createEntityManagerFactory("produtos").createEntityManager();
		return em;
	}
	
	//metodo testado ok
	public String gavar(Products produto) {
		EntityManager etm=this.getEM();
		try{
			etm.getTransaction().begin();
			etm.persist(produto);
			etm.getTransaction().commit();
			etm.close();
			return "ok";
		}
		catch(Exception e) {
			return "erro";
		}
	}
	
	//metodo testado ok
	public String deletar(Integer codigo) {
	    EntityManager entityManager = this.getEM();
	    try {
	        entityManager.getTransaction().begin();

	        Products produto = this.consultar(codigo);

	        if (entityManager.contains(produto)) {
	            entityManager.remove(produto);
	        } else {
	            Products produtoGerenciado = entityManager.merge(produto);
	            entityManager.remove(produtoGerenciado);
	        }

	        entityManager.getTransaction().commit();
	        return "ok";
	    } catch (Exception e) {
	        if (entityManager.getTransaction().isActive()) {
	            entityManager.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return "erro";
	    } finally {
	        entityManager.close();
	    }
	}
	
	//metodo ok
	public List<Products> ListarTodos() {
	    EntityManager entityManager = this.getEM();
	    try {
	        List<Products> query = entityManager.createQuery("SELECT p FROM Products p", Products.class).getResultList();
	        return query;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        entityManager.close();
	    }
	}
	
	

	
	//metodo testado ok
	public Products consultar(Integer codigo) {
		EntityManager etm=this.getEM();
		try{
			Products produtos=etm.find(Products.class, codigo);
			return produtos;
		}
		catch(Exception e) {
			return null;
		}		
		
		
	}
	
	public List<Products> buscarPorParteDoNome(String parteDoNome) {
		EntityManager etm=this.getEM();
        String jpql = "SELECT p FROM Products p WHERE p.nome LIKE :parteDoNome";
        TypedQuery<Products> query = etm.createQuery(jpql, Products.class);
        query.setParameter("parteDoNome", "%" + parteDoNome + "%");
        return query.getResultList();
    }
	
	
	
	
}
