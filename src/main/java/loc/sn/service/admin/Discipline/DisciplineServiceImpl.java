package loc.sn.service.admin.Discipline;

import loc.sn.dao.admin.Discipline.DisciplineDao;
import loc.sn.model.admin.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("disciplineService")
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    DisciplineDao disciplineDao;

    public List<Discipline> findAllDisciplines() {
        return disciplineDao.findAllDisciplines();
    }

    public Discipline findById(int id) {
        return disciplineDao.findById(id);
    }

    public void saveDiscipline(Discipline discipline) {
        disciplineDao.saveDiscipline(discipline);
    }

    public void updateDiscipline(Discipline discipline) {
        disciplineDao.updateDiscipline(discipline);
    }

    public void deleteDiscipline(String id) {
        disciplineDao.deleteDiscipline(id);
    }

    public List<Discipline> findAllDisciplineByKafedraId(int id) {
        return disciplineDao.findAllDisciplineByKafedraId(id);
    }
}
