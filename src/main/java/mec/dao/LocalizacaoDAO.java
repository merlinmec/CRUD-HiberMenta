package mec.dao;

import mec.model.Cidades;
import mec.model.Estados;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizacaoDAO {

    private SessionFactory sessionFactory;

    public LocalizacaoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Map<Integer, String> getCidadesAsMap() {
        Map<Integer, String> mapCidades = new HashMap<>();

        try (Session session = sessionFactory.openSession()) {
            List<Cidades> cidades = session.createQuery("FROM Cidades", Cidades.class).list();
            for (Cidades cidade : cidades) {
                mapCidades.put(cidade.getId(), cidade.getNome());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return mapCidades;
    }

    public Map<Integer, String> getEstadosAsMap() {
        Map<Integer, String> mapEstados = new HashMap<>();

        try (Session session = sessionFactory.openSession()) {
            List<Estados> estados = session.createQuery("FROM Estados", Estados.class).list();
            for (Estados estado : estados) {
                mapEstados.put(estado.getId(), estado.getNome());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return mapEstados;
    }
    
    public Map<Integer, String> getCidadesByEstadoId(int id_estado) {
        Map<Integer, String> mapCidadesByEstadoId = new HashMap<>();
        
        try (Session session = sessionFactory.openSession()) {
            Query<Cidades> query = session.createQuery("FROM Cidades WHERE estado.id = :id_estado", Cidades.class);
            query.setParameter("id_estado", id_estado);
            List<Cidades> cidades = query.list();
            
            for (Cidades cidade : cidades) {
                mapCidadesByEstadoId.put(cidade.getId(), cidade.getNome());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return mapCidadesByEstadoId;
    }


    
    public String getCidadeName(int idCidade) {
        try (Session session = sessionFactory.openSession()) {
            Cidades cidade = session.get(Cidades.class, idCidade);
            if (cidade != null) {
                return cidade.getNome();
            } else {
                throw new RuntimeException("Cidade não encontrada para o ID: " + idCidade);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter cidade por ID: " + e.getMessage());
        }
    }
    
    
    public int getCidadeId(String nome) {
        try (Session session = sessionFactory.openSession()) {
            Cidades cidade = session.get(Cidades.class, nome);
            if (cidade != null) {
                return cidade.getId();
            } else {
                throw new RuntimeException("Cidade não encontrada para o nome: " + nome);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter cidade por nome: " + e.getMessage());
        }
    }
    
    public String getEstadoName(int idEstado) {
        try (Session session = sessionFactory.openSession()) {
            Estados estado = session.get(Estados.class, idEstado);
            if (estado != null) {
                return estado.getNome();
            } else {
                throw new RuntimeException("Estado não encontrada para o ID: " + idEstado);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter estado por ID: " + e.getMessage());
        }
    }
    
    public int getEstadoId(String nome) {
        try (Session session = sessionFactory.openSession()) {
            Estados estado = session.get(Estados.class, nome);
            if (estado != null) {
                return estado.getId();
            } else {
                throw new RuntimeException("Estado não encontrada para o nome: " + nome);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter estado por nome: " + e.getMessage());
        }
    }
    

}
