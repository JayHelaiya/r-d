package com.logicbig.example;

import javax.persistence.*;
import javax.persistence.criteria.*;


public class ExampleMain2 {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("example-unit");

    public static void main(String[] args) {
        try {
            persistEmployees();
            findEmployeesBySupervisor();
        } finally {
            entityManagerFactory.close();
        }
    }

    public static void persistEmployees() {
        Task task1 = new Task("Coding", "Denise");
        Task task2 = new Task("Refactoring", "Rose");
        Task task3 = new Task("Designing", "Denise");
        Task task4 = new Task("Documentation", "Mike");

        Employee employee1 = Employee.create("Diana", task1, task3);
        Employee employee2 = Employee.create("Mike", task2, task4);
        Employee employee3 = Employee.create("Tim", task3, task4);
        Employee employee4 = Employee.create("Jack");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(employee4);
        em.getTransaction().commit();
        em.close();
        System.out.println("-- Employee persisted --");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
    }

    private static void findEmployeesBySupervisor() {
        System.out.println("-- find employees left joined with tasks with supervisor 'Denise' --");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<Employee> employee = query.from(Employee.class);
        ListJoin<Employee, Task> tasks = employee.join(Employee_.tasks, JoinType.LEFT);
        tasks.on(criteriaBuilder.equal(tasks.get(Task_.supervisor), "Denise"));
        query.select(criteriaBuilder.tuple(employee.get(Employee_.name).alias("employeeName"),
                tasks.get(Task_.supervisor).alias("supervisor")))
             .distinct(true);
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        for (Tuple tuple : typedQuery.getResultList()) {
            System.out.printf("name: %s, supervisor: %s%n",
                    tuple.get("employeeName", String.class),
                    tuple.get("supervisor", String.class));
        }
    }
}