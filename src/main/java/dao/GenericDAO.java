package dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

    private Class<T> klass;

    public GenericDAO(Class<T> klass) {
        this.klass = klass;
    }

    public T find(Long id) {
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        T t = entityManager.find(klass, id);
        entityManager.close();
        return t;
    }

    public T persist(T t) {
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        DatabaseHelper.beginTx(entityManager);
        entityManager.persist(t);
        DatabaseHelper.commitTxAndClose(entityManager);
        return t;
    }

    public T merge(T t) {
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        DatabaseHelper.beginTx(entityManager);
        entityManager.merge(t);
        DatabaseHelper.commitTxAndClose(entityManager);
        return t;
    }

    public void remove(Long id) {
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        DatabaseHelper.beginTx(entityManager);
        entityManager.remove(entityManager.find(klass, id));
        DatabaseHelper.commitTxAndClose(entityManager);
    }

}
