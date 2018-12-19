package top.wufl.api;

import top.wufl.bean.Result;
import top.wufl.bean.User;
import top.wufl.service.extend.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/android_server")
public class UserAPI {
    @Context
    HttpServletRequest request;

    private UserService userService = new UserService();

    @POST
    @Consumes("application/json; charset=utf-8")
    @Produces("application/json; charset=utf-8")
    @Path("/register")
    public Result register(User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(-1, "注册失败", null, "");
        }
        return new Result(0, "注册成功", user, "");
    }

    @POST
    @Path("/login")
    @Consumes("application/json; charset=utf-8")
    @Produces("application/json; charset=utf-8")
    public Result login(User user) {
        User loginUser = null;
        try {
            loginUser = userService.findById(user.getUserName());
            if (user.getPassword().equals(loginUser.getPassword())) {
                request.getSession().setAttribute("user", loginUser);
            } else {
                return new Result(-1, "登录失败, 用户名或密码错误", null, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(-1, "登录失败, 用户名或密码错误", null, "");
        }
        return new Result(0, "登录成功", "user", "");
    }
}
