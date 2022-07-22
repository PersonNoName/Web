package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.login(username, password);

        if(user != null){
            //将user对象存储到session中，方便后面调用
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //判断是否点了记住密码
            if("1".equals(remember)){
                //创建cookie
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //登录成功，重定向到目标Servlet即可
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else {
            //存储错误信息到request域中
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
