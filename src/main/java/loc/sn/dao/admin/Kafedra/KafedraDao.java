package loc.sn.dao.admin.Kafedra;

import loc.sn.model.admin.Kafedra;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface KafedraDao {

    List<Kafedra> findAllKafedras();

    Kafedra findById(int id);

    List<Kafedra> findAllKafedrasByFacultetId(int id);

    void saveKafedra(Kafedra kafedra);

    void deleteKafedra(String id);

    void updateKafedra(Kafedra kafedra);

}
