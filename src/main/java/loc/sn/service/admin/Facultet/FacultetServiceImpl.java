package loc.sn.service.admin.Facultet;

import loc.sn.dao.admin.Facultet.FacultetDao;
import loc.sn.model.admin.Facultet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Service("facultetService")
@Transactional
public class FacultetServiceImpl implements FacultetService {

    @Autowired
    FacultetDao facultetDao;

    public List<Facultet> findAllFacultets() {
        return facultetDao.findAllFacultets();
    }

    public Facultet findById(int id) {
        return facultetDao.findById(id);
    }

    public void saveFacultet(Facultet facultet) {
        facultetDao.saveFaculet(facultet);
    }

    public void updateFacultet(Facultet facultet) {
        Facultet entity = facultetDao.findById(facultet.getId());
        if (entity != null) {
            entity.setName(facultet.getName());
            entity.setShortFacName(facultet.getShortFacName());
        }
    }

    public void deleteFacultet(String id) {
        facultetDao.deleteFacultetById(id);
    }
}
