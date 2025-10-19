CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE result INT;
  DECLARE offset_value INT;

  set offset_value = N-1;
  SET result = (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET offset_value
  );
  RETURN result;
END;
