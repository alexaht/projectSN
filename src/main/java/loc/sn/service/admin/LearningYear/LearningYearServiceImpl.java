package loc.sn.service.admin.LearningYear;

import loc.sn.dao.admin.LearningYear.LearningYearDao;
import loc.sn.model.admin.LearningYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Service("learningYearService")
@Transactional
public class LearningYearServiceImpl implements LearningYearService {

    @Autowired
    LearningYearDao learningYearDao;

    public List<LearningYear> findAllLearningYears() {
        return learningYearDao.findAllLearningYears();
    }

    public LearningYear findById(int id) {
        return learningYearDao.findById(id);
    }

    public void saveLearningYear(LearningYear learningYear) {
        learningYearDao.saveLearningYear(learningYear);
    }

    public void updateLearningYear(LearningYear learningYear) {
        LearningYear entity = learningYearDao.findById(learningYear.getId());
        if (entity != null) {
            entity.setName(learningYear.getName());
            entity.setBeginYear(learningYear.getBeginYear());
            entity.setEndYear(learningYear.getEndYear());
            entity.setCurrent(learningYear.getCurrent());
        }
    }

    public void deleteLearningYear(String id) {
        learningYearDao.deleteLearningYear(id);
    }
}
