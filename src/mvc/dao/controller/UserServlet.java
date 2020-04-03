package mvc.dao.controller;

import mvc.domain.User;
import mvc.service.IUserService;
import mvc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.loginUser(userName, password);
        if (user != null) {
            resp.sendRedirect("login_success.jsp");
        } else {
            resp.sendRedirect("login_fail.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
