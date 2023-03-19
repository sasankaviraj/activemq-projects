package com.activemq.common.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
@Service
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext context;


    /***
     * Returns spring managed bean for the given class type
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> beanClass){
        return context.getBean(beanClass);
    }

    /***
     * Returns spring managed bean for the given class type
     * @param clz
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(String clz, Class<T> beanClass){
        return context.getBean(clz, beanClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    private void setContext(ApplicationContext applicationContext){
        AppContext.context = applicationContext;
    }
}
