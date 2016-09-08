package loc.sn.service.admin.Facultet;

import loc.sn.model.admin.Facultet;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface FacultetService {

    List<Facultet> findAllFacultets();

    Facultet findById(int id);

    void saveFacultet(Facultet facultet);

    void updateFacultet(Facultet facultet);

    void deleteFacultet(String id);
}
