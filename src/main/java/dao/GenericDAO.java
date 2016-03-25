package dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

    private Class<T> klass;

    public GenericDAO(Class<T> klass) {
        this.klass = klass;
    }

    public String debutReq = "FROM" ;

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

    public String buildRequest(String req){
        //Si la requete après le WHERE n'est pas vide on ajoute un WHERE au début de la requete
        if(!req.equals("")){
            req = (debutReq+" WHERE "+req) ;
        }
        //Sinon on ajoute rien
        else{
            req = debutReq ;
        }
        // Si la requete finit par AND
        if(req.endsWith("AND"))
            // On enleve le AND a la fin de la requete
            req = req.substring(0,req.length()-3) ;

        return req ;
    }
}
