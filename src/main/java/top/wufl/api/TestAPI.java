package top.wufl.api;

import top.wufl.bean.Result;
import top.wufl.bean.User;
import top.wufl.service.extend.UserService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/p1")
public class TestAPI {
    private UserService userService = new UserService();

    @POST
    @Path("/p2")
    @Produces("text/html; charset=utf-8")
    public String testMethod() {
        return "Hi~";
    }

    @POST
    @Path("getUser")
    @Produces("application/json; charset=utf-8")
    public Result getUser() {
        User user = new User();
        user.setUserName("123456");
        user.setPassword("123456");
        return new Result(0, "获取用户成功", user, "");
    }

    @POST
    @Path("getAllUser")
    @Produces("application/json; charset=utf-8")
    public Result getAllUser() {
        List<User> users = null;
        try {
            users = userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(0, "获取用户成功", users, "");
    }
}
