package loc.sn.dao.admin.Facultet;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.Facultet;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("facultetDao")
public class FacultetDaoImpl extends AbstractDao<Integer,Facultet> implements FacultetDao {

    public List<Facultet> findAllFacultets() {
        Criteria criteria = createEntityCriteria();
        return (List<Facultet>)criteria.list();
    }

    public Facultet findById(int id) {
        return getByKey(id);
    }

    public void saveFaculet(Facultet facultet) {
        persist(facultet);
    }

    public void deleteFacultetById(String id) {
        Query query = getSession().createQuery("delete from Facultet where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }
}
