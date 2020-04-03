package mvc.dao;

import mvc.domain.User;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public interface IUserDao {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public User loginUser(String username, String password);
}
