package mvc.service.impl;

import mvc.dao.IUserDao;
import mvc.dao.impl.UserDaoImpl;
import mvc.domain.User;
import mvc.service.IUserService;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public User loginUser(String username, String password) {
        return dao.loginUser(username, password);
    }
}
