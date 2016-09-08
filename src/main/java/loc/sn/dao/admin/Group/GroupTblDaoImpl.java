package loc.sn.dao.admin.Group;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.GroupTbl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Repository("groupTblDao")
public class GroupTblDaoImpl extends AbstractDao<Integer, GroupTbl> implements GroupTblDao {

    public List<GroupTbl> findAllGroupTbl() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("kurs"));
        return (List<GroupTbl>) criteria.list();
    }

    public GroupTbl getById(int id) {
        return getByKey(id);
    }

    public void saveGroupTbl(GroupTbl groupTbl) {
        persist(groupTbl);
    }

    public void deleteGroupTbl(String id) {
        Query query = getSession().createQuery("delete from GroupTbl where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    public void updateGroupTbl(GroupTbl groupTbl) {
        merge(groupTbl);
    }
}
