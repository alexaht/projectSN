package loc.sn.service.admin.Kafedra;

import loc.sn.dao.admin.Kafedra.KafedraDao;
import loc.sn.model.admin.Kafedra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Service("kafedraService")
@Transactional
public class KafedraServiceImpl implements KafedraService {

    @Autowired
    KafedraDao kafedraDao;

    public List<Kafedra> findAllKafedras() {
        return kafedraDao.findAllKafedras();
    }

    public Kafedra findById(int id) {
        return kafedraDao.findById(id);
    }

    public List<Kafedra> findAllKafedrasByFacultetId(int id) {
        return kafedraDao.findAllKafedrasByFacultetId(id);
    }

    public void saveKafedra(Kafedra kafedra) {
        kafedraDao.saveKafedra(kafedra);
    }

    public void updateKafedra(Kafedra kafedra) {
        kafedraDao.updateKafedra(kafedra);
    }

    public void deleteKafedra(String id) {
        kafedraDao.deleteKafedra(id);
    }
}
