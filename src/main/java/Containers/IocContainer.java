package Containers;

import Config.BeanConfig;
import Initialize.BeanLifeCycle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import Containers.Employee;

public class IocContainer {
    // There are two types of IoC (Inversion of Control) containers: make injection and init of beans when we call it
    //BeanFactory  --simple container using in simple projects

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        //context.register(OtherConfig1.class, OtherConfig2.class); if we want to make 1 than more from config
        context.refresh();

        /*BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = (Employee) factory.getBean("emp");
        employee.printMethod();*/

        /*-- when we use DisposableBean in BeanLifeCycle
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();*/

        //ApplicationContext  -- more functionality built on top of the BeanFactory interface
        // method of implementation FileSystemXmlApplicationContext(locate from anywhere)- ClassPathXmlApplicationContext - WebXmlApplicationContext
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

       /* -- when singleton in the first and second time name field will not be null
        this will be when name property in bean not defined
        but in prototype the name field will be the last name we set it will be the same in every project instance
        Employee emp1 = (Employee) applicationContext.getBean("emp");
        emp1.setName("Rasha");
        Employee emp2 = (Employee) applicationContext.getBean("emp");

        emp1.printMethod();
        emp2.printMethod();*/
    }
}
