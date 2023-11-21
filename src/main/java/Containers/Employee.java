package Containers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PreDestroy;
import java.util.List;

public class Employee {

    // Dependency Injection (DI) is a design pattern used to implement IoC. allows the creation of dependent objects
    //through different ways.
    private Long id;
    private String name;
    private Double salary;
    private Department department;

    private Department department2;

    private List<String> address;

    private List<Book> books;

    // There are two ways to perform Dependency Injection in Spring framework:
    // The first one is by Constructor and  the last one is by Setter Methods

    // to achieve Dependency Lookup approach we get the resource after demand by
    //new Object Or Static method


    public Employee() {
    }

    // call this method in bean init-method="init" destroy-method="destroy"
    public void init(){
        System.out.println("initialize method Employee class");
    }

    public void destroy(){
        System.out.println("destroy method Employee class");
    }

    public Employee(Long id, String name, Double salary, Department department, List<String> address, List<Book> books) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.address = address;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    @Required
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    @Qualifier("dept")
    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Department getDepartment2() {
        return department2;
    }

    @Autowired
    @Qualifier("dept2")
    public void setDepartment2(Department department2) {
        this.department2 = department2;
    }

    /*@PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }*/

    public void printMethod(){
        System.out.println("Employee Name:" + this.name + "ID:" + this.id);
        System.out.println("Department Name:" + department.getName() + "ID:" + department.getId());

        for(String item: address){
            System.out.println("Address is :" + item);
        }

        for(Book item: books){
            System.out.println("Book is :" + item.getName());
        }
    }
}
