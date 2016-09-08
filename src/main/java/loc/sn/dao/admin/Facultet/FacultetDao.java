package loc.sn.dao.admin.Facultet;

import loc.sn.model.admin.Facultet;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface FacultetDao {
    List<Facultet> findAllFacultets();

    Facultet findById(int id);

    void saveFaculet(Facultet facultet);

    void deleteFacultetById(String id);
}
