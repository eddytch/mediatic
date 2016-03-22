package dao;

import model.Media;

/**
 * Created by utilisateur on 23/03/2016.
 */
public class MediaDAO extends GenericDAO<Media> {

    private static MediaDAO dao;

    public MediaDAO() {
        super(Media.class);
    }

    public static MediaDAO instance() {
        if (dao == null) {
            dao = new MediaDAO();
        }
        return dao;
    }
}
