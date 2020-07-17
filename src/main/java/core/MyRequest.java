package core;

import javax.servlet.http.*;
import java.util.UUID;

public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletResponse response;
    private HttpServletRequest request;

    public MyRequest(HttpServletRequest request, HttpServletResponse response) {
        super(request);
        this.response=response;
        this.request=request;
    }

    /**
     * 重写request中的getSession方法
     * 传入自生成的sessionId
     * @return
     */
    @Override
    public HttpSession getSession() {
        //获取cookie
        Cookie[] cookies=request.getCookies();
        //创建sessionId
        String sessionId=null;
        //循环查找sessionId
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                //如果存在sessionId则保存
                if (cookie.equals("sessionId")){
                    sessionId=cookie.getValue();
                    break;
                }
            }
        }
        //如果cookies中不存在sessionId或者cookies为空则创建新的
        if(sessionId==null){
            sessionId= UUID.randomUUID().toString();
            //创建cookie
            Cookie cookie=new Cookie("sessionId", sessionId);
            response.addCookie(cookie);
        }

        //有了sessionId以后通过自定义的MySession创建自己的session
        MySession session=new MySession(sessionId);
        return session;
    }
}
