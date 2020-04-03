package mvc.service;

import mvc.domain.User;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public interface IUserService {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User loginUser(String username, String password);
}
