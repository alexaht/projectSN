package loc.sn.dao.admin.LearningYear;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.LearningYear;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Repository("learningYearDao")
public class LearningYearDaoImpl extends AbstractDao<Integer, LearningYear> implements LearningYearDao {

    public List<LearningYear> findAllLearningYears() {
        Criteria criteria = createEntityCriteria();
        return (List<LearningYear>) criteria.list();
    }

    public LearningYear findById(int id) {
        return getByKey(id);
    }

    public void saveLearningYear(LearningYear learningYear) {
        persist(learningYear);
    }

    public void deleteLearningYear(String id) {
        Query query = getSession().createQuery("delete from LearningYear where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

}
