package loc.sn.dao.admin.Kafedra;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.Kafedra;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Repository("kafedraDao")
public class KafedraDaoImpl extends AbstractDao<Integer, Kafedra> implements KafedraDao {

    public List<Kafedra> findAllKafedras() {
        Criteria criteria = createEntityCriteria();
        return (List<Kafedra>) criteria.list();
    }

    public Kafedra findById(int id) {
        return getByKey(id);
    }

    public List<Kafedra> findAllKafedrasByFacultetId(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("facultet.id",id));
        return (List<Kafedra>) criteria.list();
    }

    public void saveKafedra(Kafedra kafedra) {
        persist(kafedra);
    }

    public void deleteKafedra(String id) {
        Query query = getSession().createQuery("DELETE from Kafedra where id=:id");
        query.setString("id", id);
        query.executeUpdate();
    }

    public void updateKafedra(Kafedra kafedra) {
        merge(kafedra);
    }
}
