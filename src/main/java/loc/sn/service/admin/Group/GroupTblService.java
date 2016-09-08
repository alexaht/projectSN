package loc.sn.service.admin.Group;

import loc.sn.model.admin.GroupTbl;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface GroupTblService {

    List<GroupTbl> findAllGroupTbl();

    GroupTbl findById(int id);

    void saveGroupTbl(GroupTbl groupTbl);

    void updateGroupTbl(GroupTbl groupTbl);

    void deleteGroupTbl(String id);

}
