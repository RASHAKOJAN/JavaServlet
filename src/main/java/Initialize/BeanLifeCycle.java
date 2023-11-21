package Initialize;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanLifeCycle implements InitializingBean, DisposableBean ,BeanPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("when bean is initializing");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("when bean is destroy");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("process before intialization bean name"+ beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("process after intialization bean name"+ beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
