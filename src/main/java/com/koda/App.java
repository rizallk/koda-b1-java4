package com.koda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("ACTIVE QUERY\n");

        List<Employee> list = new ArrayList<>();

        list.add(new Employee("KR001", "Andi", "Frontend", "IT", 6000000));
        list.add(new Employee("KR002", "Budi", "Backend", "IT", 5000000));
        list.add(new Employee("KR003", "Citra", "DevOps", "IT", 7000000));

        System.out.println("Menampilkan Employee dengan salary >= Rp200.000");
        list.stream().filter(emp -> emp.salary > 200_000)
                .forEach(emp -> System.out.println(emp.name + " : Rp" + emp.salary));

        System.out.println("\nUrutkan salary dari terbesar");
        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(emp -> System.out.println(emp.name + " : Rp" + emp.salary));
        ;

        System.out.println("\nMenampilkan daftar nama employee");
        list.stream().map(Employee::getName).forEach(System.out::println);
        ;

        System.out.println("\nCari Employee berdasarkan employeeID");
        try {
            Employee result = findEmployee(list, "KR002")
                    .orElseThrow(() -> new NoSuchElementException("Tidak ditemukan"));
            System.out.println(result.getName());
        } catch (NoSuchElementException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    static Optional<Employee> findEmployee(List<Employee> employees, String empId) {
        return employees.stream().filter(emp -> emp.getEmployeeId().equals(empId)).findFirst();
    }
}
