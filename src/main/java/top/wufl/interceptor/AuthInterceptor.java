package top.wufl.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import top.wufl.annotation.Auth;
import top.wufl.bean.Result;
import top.wufl.bean.User;

@SuppressWarnings("deprecation")
public class AuthInterceptor implements PreProcessInterceptor {
    @Context
    HttpServletRequest request;

    @Override
    public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethodInvoker resourceMethodInvoker)
            throws Failure, WebApplicationException {
        System.out.println("AuthInterceptor");
        Method method = resourceMethodInvoker.getMethod();
        // @Auth("login") 需要登录
        boolean needAuth = method.isAnnotationPresent(Auth.class);
        if (needAuth) {
            Auth auth = method.getAnnotation(Auth.class);
            String authValue = auth.value();
            // 已经登录的用户以user-User对象 的键值对方式存放到session中
            User user = (User) request.getSession().getAttribute("user");
            boolean isNeedLogin = "login".equals(authValue);
            //	登录校验
            if (isNeedLogin) {
                if (user == null) {
                    return new ServerResponse(new Result(-1, "请登录!", null, "LoginActivity"), 200, new Headers<Object>());
                }
            }
        }
        return null;
    }
}