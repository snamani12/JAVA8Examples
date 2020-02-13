package com.nisum.examples.streamexamples;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsTest {

    public static void main(String[] args) {
        //new StreamsTest().filterTest();
        //new StreamsTest().mapTest();
        //new StreamsTest().getNames();
        new StreamsTest().getEmployee(888);
    }

    public Employee getEmployee(int id){
        List<Employee> employees = getEmployees();
        Employee employee = employees.stream().filter(emp -> emp.getEmployeeId() == id).collect(O);
        return employee;
    }

    public void flatMapTest() {
        List<Employee> employees = getEmployees();
        //List<List<String>> collect = employees.stream().map(e -> e.getSkillSet()).collect(Collectors.toList());
        List<String> flatMap = employees.stream().flatMap(e -> e.getSkillSet().stream()).collect(Collectors.toList());
        flatMap.forEach(System.out::println);

    }


    private void getNames() {
        List<Employee> list = getEmployees();
        List<String> employeeList = list.stream().map(e -> e.getFirstName()).collect(Collectors.toList());
        System.out.println("Employee Names : " + employeeList);
        List<String> employeeNamesInUpperCase = list.stream().map(e -> e.getFirstName().toUpperCase()).collect(Collectors.toList());
        System.out.println("Employee Names in Uppercase: " + employeeNamesInUpperCase);
    }

    public void filterTest() {
        List<Employee> employees = getEmployees();
        List<Employee> nonBillable = employees.stream().filter(emp -> emp.getIsBillable().equals("N"))
                .collect(Collectors.toList());
        nonBillable.forEach(e -> System.out.println(e.getFirstName()));
    }

    public void mapTest() {
        List<Employee> employees = getEmployees();
        List<String> employeeNames = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                .collect(Collectors.toList());
        employeeNames.forEach(System.out::println);
    }

    // Who are available to place in to new project
    public void flatMapTest1() {
        List<Employee> employees = getEmployees();
        // List<List<String>> collect = employees.stream().map(e ->
        // e.getSkillSet()).collect(Collectors.toList());
        Set<String> flatMap = employees.stream().filter(e -> e.getIsBillable().equals("N"))
                .flatMap(e -> e.getSkillSet().stream()).collect(Collectors.toSet());
        flatMap.forEach(System.out::println);

    }

    // Unique skill set
    public void distinctTest() {
        List<Employee> employees = getEmployees();
        // List<List<String>> collect = employees.stream().map(e ->
        // e.getSkillSet()).collect(Collectors.toList());
        List<String> flatMap = employees.stream().flatMap(e -> e.getSkillSet().stream()).distinct()
                .collect(Collectors.toList());
        flatMap.forEach(System.out::println);

    }

    public void sortedTest() {
        List<Employee> employees = getEmployees();
        List<String> employeeNames = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).sorted()
                .collect(Collectors.toList());
        employeeNames.forEach(System.out::println);

    }
    public void sortedTest1() {
        List<Employee> employees = getEmployees();
		/*List<String> employeeNames = employees.stream()
				.map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).sorted()
				.collect(Collectors.toList());*/

	/*	List<String> employeeNames = employees.stream()
				.map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());*/

        List<String> employeeNames = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        employeeNames.forEach(System.out::println);

    }

    public void peekTest() {
        List<Employee> employees = getEmployees();
        List<String> flatMap = employees.stream().
                flatMap(e -> e.getSkillSet().stream()).
                peek(e -> System.out.println(e)).
                collect(Collectors.toList());

    }
    public void limitTest() {
        List<Employee> employees = getEmployees();
        List<String> employeeNames = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                .limit(4).collect(Collectors.toList());

        employeeNames.forEach(System.out::println);

    }
    public void skipTest() {
        List<Employee> employees = getEmployees();
        List<String> employeeNames = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                .skip(2).collect(Collectors.toList());

        employeeNames.forEach(System.out::println);

    }


    /*    TERMINAL OPERATIONS */

    public void forEachTest() {
        List<Employee> employees = getEmployees();
        employees.parallelStream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).forEach(System.out::println);

    }
    public void forEachOrderedTest() {
        List<Employee> employees = getEmployees();
        employees.parallelStream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase()).forEachOrdered(System.out::println);

    }

    public void countTest() {
        List<Employee> employees = getEmployees();
        long countEmployees = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                .count();
        System.out.println("Total number of employees : "+countEmployees);

    }
    public void toArrayTest() {
        List<Employee> employees = getEmployees();
        Object[] array = employees.stream()
                .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                .toArray();
        for(Object obj : array) {
            System.out.println(obj);
        }

    }
    public void minMaxTest() {
        List<Employee> employees = getEmployees();
        double max = employees.stream().map(e ->e.getSalary()).max(Comparator.comparing(Double::doubleValue)).get();
        double min = employees.stream().map(e ->e.getSalary()).min(Comparator.comparing(Double::doubleValue)).get();
        System.out.println("MIN : "+min + "  "+ "MAX : "+max);

    }

    public void findFirstAndANyTest() {
        List<Employee> employees = getEmployees();
        Optional<Employee> findFirst = employees.stream().findFirst();
        findFirst.ifPresent( e-> System.out.println("Find first : "+e.getFirstName()));

        Optional<Employee> findAny = employees.stream().findAny();
        findAny.ifPresent( e-> System.out.println("Find Any : "+e.getFirstName()));

    }
    public void matchTest() {
        List<Employee> employees = getEmployees();
        boolean anyMatch = employees.stream().anyMatch(e -> e.getFirstName().startsWith("M"));
        boolean nonMatch = employees.stream().noneMatch(e -> e.getFirstName().startsWith("B"));
        boolean allMatch = employees.stream().allMatch(e -> e.getFirstName().startsWith("M"));

        System.out.println("anyMatch : "+anyMatch);
        System.out.println("noneMatch : "+nonMatch);
        System.out.println("allMatch : "+allMatch);


    }



    public static List<Employee> getEmployees() {
        Department it = new Department(200, "IT-OPS");
        Department admin = new Department(100, "Admin");
        Department dev = new Department(400, "IT-DEV");
        Department qa = new Department(300, "IT-QA");
        Department hr = new Department(500, "HR");

        List<String> skillSet1 = Arrays.asList("Java8","spring boot","Angular","oracle");
        List<String> skillSet2 = Arrays.asList("Java8","spring mvc","React","Mysql");
        List<String> skillSet3 = Arrays.asList("Java8","spring","kafka","cassandra");
        List<String> skillSet4 = Arrays.asList("Java8","spring","spark","mongodb");
        List<String> skillSetQa1 = Arrays.asList("Java8","Junit","Mockito","cassandra");
        List<String> skillSetQa2 = Arrays.asList("Java8","Junit","selenium","Oracle");

        Employee employeeDev1 = new Employee(888, "Mowgli", "JungleBook", 700000.00, "JDEV", "N", dev, skillSet1);
        Employee employeeDev2 = new Employee(666, "Johney", "Yespappa", 800000.00, "JDEV", "B", dev, skillSet2);
        Employee employeeDev3 = new Employee(555, "Tom", "Talking", 900000.00, "JDEV", "N", dev, skillSet3);
        Employee employeeDev4 = new Employee(444, "Angela", "Tom", 940000.00, "JDEV", "B", dev, skillSet4);

        Employee employeeQa1 = new Employee(999, "Micky", "Mouse", 950000.00, "QA", "B", dev, skillSetQa1);
        Employee employeeQa2 = new Employee(999, "Share", "Khan", 960000.00, "QA", "N", dev, skillSetQa2);

        List<Employee> employees = new ArrayList<>();
        employees.add(employeeDev1);
        employees.add(employeeDev2);
        employees.add(employeeDev3);
        employees.add(employeeDev4);
        employees.add(employeeQa1);
        employees.add(employeeQa2);
        return employees;

    }
}
