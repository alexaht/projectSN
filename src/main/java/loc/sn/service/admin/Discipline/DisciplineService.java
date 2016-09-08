package loc.sn.service.admin.Discipline;

import loc.sn.model.admin.Discipline;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface DisciplineService {

    List<Discipline> findAllDisciplines();

    Discipline findById(int id);

    void saveDiscipline(Discipline discipline);

    void updateDiscipline(Discipline discipline);

    void deleteDiscipline(String id);

    List<Discipline> findAllDisciplineByKafedraId(int id);
}
