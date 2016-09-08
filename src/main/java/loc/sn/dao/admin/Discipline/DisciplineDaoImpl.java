package loc.sn.dao.admin.Discipline;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.Discipline;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("disciplineDao")
public class DisciplineDaoImpl extends AbstractDao<Integer, Discipline> implements DisciplineDao {

    public List<Discipline> findAllDisciplines() {
        Criteria criteria = createEntityCriteria();
        return (List<Discipline>) criteria.list();
    }

    public Discipline findById(int id) {
        return getByKey(id);
    }

    public void saveDiscipline(Discipline discipline) {
        persist(discipline);
    }

    public void updateDiscipline(Discipline discipline) {
        merge(discipline);
    }

    public void deleteDiscipline(String id) {
        Query query = getSession().createQuery("delete from Discipline where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    public List<Discipline> findAllDisciplineByKafedraId(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("kafedra.id", id));
        return (List<Discipline>) criteria.list();
    }
}
