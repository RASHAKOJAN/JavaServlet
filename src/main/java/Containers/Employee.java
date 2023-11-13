package Containers;

import java.util.List;

public class Employee {

    // Dependency Injection (DI) is a design pattern used to implement IoC. allows the creation of dependent objects
    //through different ways.
    private Long id;
    private String name;
    private Double salary;
    private Department department;

    private List<String> address;

    private List<Book> books;

    // There are two ways to perform Dependency Injection in Spring framework:
    // The first one is by Constructor and  the last one is by Setter Methods

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

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

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
