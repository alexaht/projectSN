package loc.sn.service.admin.Group;

import loc.sn.dao.admin.Group.GroupTblDao;
import loc.sn.model.admin.GroupTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Service("groupTblService")
@Transactional
public class GroupTblServiceImpl implements GroupTblService {

    @Autowired
    GroupTblDao groupDao;

    public List<GroupTbl> findAllGroupTbl() {
        return groupDao.findAllGroupTbl();
    }

    public GroupTbl findById(int id) {
        return groupDao.getById(id);
    }

    public void saveGroupTbl(GroupTbl groupTbl) {
        groupDao.saveGroupTbl(groupTbl);
    }

    public void updateGroupTbl(GroupTbl groupTbl) {
        groupDao.updateGroupTbl(groupTbl);
    }

    public void deleteGroupTbl(String id) {
        groupDao.deleteGroupTbl(id);
    }

}
