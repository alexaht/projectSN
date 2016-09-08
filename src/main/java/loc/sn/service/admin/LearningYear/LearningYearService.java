package loc.sn.service.admin.LearningYear;

import loc.sn.model.admin.LearningYear;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface LearningYearService {

    List<LearningYear> findAllLearningYears();

    LearningYear findById(int id);

    void saveLearningYear(LearningYear learningYear);

    void updateLearningYear(LearningYear learningYear);

    void deleteLearningYear(String id);
}
