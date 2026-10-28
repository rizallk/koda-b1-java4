package com.koda;

import java.util.Objects;

public class Employee {
  protected String employeeId;
  protected String name;
  protected String position;
  protected String department;
  protected int salary;

  public Employee(String employeeId, String name, String position, String department, int salary) {
    this.employeeId = employeeId;
    this.name = name;
    this.position = position;
    this.department = department;
    this.salary = salary;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Employee employee = (Employee) o;

    return employeeId.equals(employee.employeeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId);
  }

  public void showInfo() {
    System.out.println("Employee ID : " + employeeId);
    System.out.println("Name : " + name);
    System.out.println("Position : " + position);
    System.out.println("Department : " + department);
    System.out.println("Salary : Rp " + salary);
  }

  public void showCurrentSalary() {
    System.out.println("Current Salary : Rp " + salary);
  }
}
