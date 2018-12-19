package top.wufl.api;

import top.wufl.annotation.Auth;
import top.wufl.bean.Result;
import top.wufl.bean.User;
import top.wufl.bean.Video;
import top.wufl.service.extend.VideoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/android_server")
public class VideoAPI {
    private VideoService videoService = new VideoService();

    /**
     * 通过用户请求视频资源
     *
     * @param user
     * @return
     */
    @POST
    @Path("getAllVideos")
    @Consumes("application/json; charset=utf-8")
    @Produces("application/json; charset=utf-8")
    @Auth("login")
    public Result getAllVideos(User user) {
        List<Video> videos = null;
        String description = "";
        try {
            videos = videoService.findByFieldName("userName", user.getUserName());
            description = "查询成功";
        } catch (Exception e) {
            System.out.println("数据库错误");
            description = "查询失败, 数据库错误";
        }
        return new Result(0, description, videos, "");
    }
}
