package top.wufl.api;

import top.wufl.annotation.Auth;
import top.wufl.bean.Result;
import top.wufl.bean.User;
import top.wufl.bean.Video;
import top.wufl.service.extend.VideoService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/android_server")
public class VideoAPI {
    private VideoService videoService = new VideoService();
    @Context
    HttpServletRequest request;

    /**
     * 通过用户请求视频资源
     *
     * @return
     */
    @POST
    @Path("getAllVideos")
    @Consumes("application/json; charset=utf-8")
    @Produces("application/json; charset=utf-8")
    @Auth("login")
    public Result getAllVideos() {
        List<Video> videos = null;
        String description = "";
        User user = (User) request.getSession().getAttribute("user");
        try {
            videos = videoService.findByFieldName("userName", user.getUserName());
            description = "视频资源查询成功";
        } catch (Exception e) {
            System.out.println("数据库错误");
            description = "视频资源查询失败, 数据库错误";
        }
        return new Result(0, description, videos, "");
    }
}
