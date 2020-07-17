package core;

import redis.RedisUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;


public class MySession implements HttpSession {
    //自定义的sessionId
    private String sessionId;
    //默认最大保存时间10分钟
    private int maxInternal=60*10;


    private RedisUtil redisUtil;

    /**
     * 重写构造方法，将sessionId传入
     * @param sessionId
     */
    public MySession(String sessionId) {
        this.sessionId=sessionId;
//        this.redisUtil= (RedisUtil) ContextLoaderListener.getCurrentWebApplicationContext().getBean("redisUtil");
    }

    /**
     * 重写session保存时间的方法
     * 默认10分钟，如果用该方法设置，则修改默认值
     * @param i
     */
    @Override
    public void setMaxInactiveInterval(int i) {
        this.maxInternal=i;
    }

    /**
     * 重写getAttribute方法
     * 从redis中获取数据
     * @param s
     * @return
     */
    @Override
    public Object getAttribute(String s) {
        Object object=redisUtil.hget(sessionId,s);
        return null;
    }
    /**
     * 重写setAttribute方法
     * 向redis中写入数据
     * @param s
     * @param o
     */
    @Override
    public void setAttribute(String s, Object o) {
        redisUtil.hset(sessionId,s,o,maxInternal);
    }

    /**
     * 重写remove方法
     * 从redis中删除数据
     * @param s
     */
    @Override
    public void removeAttribute(String s) {
        redisUtil.hdel(sessionId,s);
    }

    @Override
    public void invalidate() {

    }





    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }



    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }



    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }



    @Override
    public void putValue(String s, Object o) {

    }



    @Override
    public void removeValue(String s) {

    }



    @Override
    public boolean isNew() {
        return false;
    }
}
