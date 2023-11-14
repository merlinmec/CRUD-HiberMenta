package mec.dao;

import mec.model.Contato;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class ContatoDAO {

    private SessionFactory sessionFactory;

    public ContatoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createContato(Contato contato) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                session.save(contato);

                transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void deleteContato(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Contato contato = session.get(Contato.class, id);
                if (contato != null) {
                    session.delete(contato);
                    transaction.commit();
                    System.out.println("Contato excluído!");
                } else {
                    System.out.println("Contato não encontrado com o ID: " + id);
                }
            } catch (HibernateException e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> listContatos() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Contato", Contato.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateContato(Contato contato, int id) {
    	Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Contato contatoExistente = session.get(Contato.class, id);

            if (contatoExistente != null) {
            	
                contatoExistente.setNome(contato.getNome());
                contatoExistente.setTelefone(contato.getTelefone());
                contatoExistente.setEmail(contato.getEmail());
                contatoExistente.setRua(contato.getRua());
                contatoExistente.setNumero(contato.getNumero());
                contatoExistente.setBairro(contato.getBairro());
                contatoExistente.setCidade(contato.getCidade());
                contatoExistente.setEstado(contato.getEstado());
            } else {
                System.out.println("Contato não encontrado com o ID: " + id);
            }

            transaction.commit();
        } catch (HibernateException e ) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


    public Contato selectContato(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Contato.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Contato findByTelefone(String telefone) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Contato WHERE telefone = :telefone", Contato.class)
                    .setParameter("telefone", telefone)
                    .uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Contato findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Contato WHERE email = :email", Contato.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
    
    

