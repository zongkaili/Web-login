package mvc.dao.impl;

import mvc.JdbcUtil;
import mvc.dao.IUserDao;
import mvc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.toString() + " >>> 登录成功");
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
