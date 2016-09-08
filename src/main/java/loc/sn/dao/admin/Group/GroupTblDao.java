package loc.sn.dao.admin.Group;

import loc.sn.model.admin.GroupTbl;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface GroupTblDao {

    List findAllGroupTbl();

    GroupTbl getById(int id);

    void saveGroupTbl(GroupTbl groupTbl);

    void deleteGroupTbl(String id);

    void updateGroupTbl(GroupTbl groupTbl);
}
