package com.sav.common.context;

import com.sav.common.constant.CommonConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaikai on 2018/1/13.
 */
public class BaseContextHandler {


    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key,Object value){
        Map<String,Object> map = threadLocal.get();
        if (map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key,value);
    }

    public static Object get(String key){
        Map<String,Object> map = threadLocal.get();
        if (map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public void remove(){
        threadLocal.remove();
    }

    public static String getUserName(){
        Object value = BaseContextHandler.get(CommonConstants.CONTEXT_KEY_USERNAME);
        return returnValue(value);
    }


    public static String getUserId(){
        Object value = BaseContextHandler.get(CommonConstants.CONTEXT_KEY_USER_ID);
        return returnValue(value);
    }

    private static String returnValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void setUserName(String userName){
        BaseContextHandler.set(CommonConstants.CONTEXT_KEY_USERNAME,userName);
    }

    public static void setUserId(String userId){
        BaseContextHandler.set(CommonConstants.CONTEXT_KEY_USER_ID,userId);
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        public Logger logger = LoggerFactory.getLogger(UnitTest.class);


        /**
         * 测试多线程的情况下 contex容器对于上下文环境存储是否正常
         */
        @Test
        public void testGetContext() throws InterruptedException {

            BaseContextHandler.set("main","main1");

            new Thread(()->{
                BaseContextHandler.set("test1", "itnao");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Assert.assertEquals(BaseContextHandler.get("test1"), "itnao");
                logger.info("thread1 done");
            }).start();

            new Thread(()->{
                BaseContextHandler.set("test1", "itnao");
                Assert.assertEquals(BaseContextHandler.get("test1"), "itnao");
                logger.info("thread2 done");
            }).start();

            Thread.currentThread().sleep(5000);
            Assert.assertEquals(BaseContextHandler.get("main"),"main1");
            logger.info("main done");
        }


        /**
         * 测试用户名ID和姓名的存取
         */
        @Test
        public void testUser() throws InterruptedException {
            BaseContextHandler.setUserId("123456");
            Assert.assertEquals(BaseContextHandler.getUserId(), "123456");
            BaseContextHandler.setUserName("itnao1");
            Assert.assertEquals(BaseContextHandler.getUserName(),"itnao1");
        }
    }
}
