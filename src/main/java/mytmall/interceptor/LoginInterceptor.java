package mytmall.interceptor;

import mytmall.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String[] noNeedAuthPage
                = {"home",
                "login",
                "register",
                "product",
                "checkLogin",
                "loginAjax",
                "loginPage",
                "registerPage",
                "registerSuccessPage"
        };

        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        String contextPath = session.getServletContext().getContextPath();
        uri = StringUtils.remove(uri, contextPath);

        if(uri.startsWith("/fore"))
        {
            String method = StringUtils.substringAfterLast(uri, "/fore_");
            if(!Arrays.asList(noNeedAuthPage).contains(method))
            {
                User user = (User) session.getAttribute("user");
                if(user==null)
                {
                    response.sendRedirect("loginPage");
                    return false;
                }
            }
        }

        return true;
    }
}
