-- Write your MySQL query statement below

SELECT e.name AS Employee FROM Employee e INNER JOIN Employee f ON e.managerId = f.id
WHERE e.salary > f.salary;