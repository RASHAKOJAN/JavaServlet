package Containers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class IocContainer {
    // There are two types of IoC (Inversion of Control) containers: make injection and init of beans when we call it
    //BeanFactory  --simple container using in simple projects

    BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
    Employee employee = (Employee) factory.getBean("emp");

    //ApplicationContext  -- more functionality built on top of the BeanFactory interface
    // method of implementation FileSystemXmlApplicationContext(locate from anywhere)- ClassPathXmlApplicationContext - WebXmlApplicationContext
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Employee employee2 = (Employee) applicationContext.getBean("emp");
}
