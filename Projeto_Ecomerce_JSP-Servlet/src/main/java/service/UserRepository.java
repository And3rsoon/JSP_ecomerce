package service;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import dao.Products;
import dao.User;

public class UserRepository {
	
	
	
	//criação do Entity Manager 
	public EntityManager getEM() {
		EntityManagerFactory etf=Persistence.createEntityManagerFactory("cliente");
		EntityManager em=etf.createEntityManager();
		return em;
	}
	
	public String gavar(User user) {
		EntityManager etm=this.getEM();
		try{
			etm.getTransaction().begin();
			etm.persist(user);
			etm.getTransaction().commit();
			etm.close();
			return "ok";
		}
		catch(Exception e) {
			return "erro";
		}
	}
	
	public String deletar(String cpf) {
		EntityManager entityManager = this.getEM();
	    try {
	        entityManager.getTransaction().begin();

	        User user = this.consultar(cpf);

	        if (entityManager.contains(user)) {
	            entityManager.remove(user);
	        } else {
	            User user1 = entityManager.merge(user);
	            entityManager.remove(user1);
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
	
	public List<User> ListarTodos() {
		EntityManager entityManager = this.getEM();
	    try {
	        List<User> query = entityManager.createQuery("SELECT p FROM Products p", User.class).getResultList();
	        return query;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        entityManager.close();
	    }
	}
	
	public User consultar(String cpf) {
		EntityManager etm=this.getEM();
		try{
			etm.getTransaction().begin();
			User user=etm.find(User.class, cpf);
			
			etm.close();
			return user;
		}
		catch(Exception e) {
			return null;
		}		
		
	}
	
	
	public boolean contain(String cpf){
		User user=this.consultar(cpf);
		EntityManager etm=this.getEM();
		User user1 = etm.merge(user);
		etm.getTransaction().begin();
		return etm.contains(user1);
	}
	
}
