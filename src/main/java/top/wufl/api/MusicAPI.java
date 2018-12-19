package top.wufl.api;

import top.wufl.annotation.Auth;
import top.wufl.bean.Music;
import top.wufl.bean.Result;
import top.wufl.bean.User;
import top.wufl.service.extend.MusicService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/android_server")
public class MusicAPI {
    private MusicService musicService = new MusicService();
    @Context
    HttpServletRequest request;
    /**
     * 通过用户请求视频资源
     *
     * @return
     */
    @POST
    @Path("/getAllMusics")
    @Consumes("application/json; charset=utf-8")
    @Produces("application/json; charset=utf-8")
    @Auth("login")
    public Result getAllMusic() {
        List<Music> videos = null;
        User user = (User) request.getSession().getAttribute("user");
        String description = "";
        try {
            videos = musicService.findByFieldName("userName", user.getUserName());
            description = "所有音乐资源查询成功";
        } catch (Exception e) {
            System.out.println("数据库错误");
            description = "音乐资源查询失败, 数据库错误";
        }
        return new Result(0, description, videos, "");
    }
}