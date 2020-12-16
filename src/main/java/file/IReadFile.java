package file;

import model.Employee;

import java.util.List;

public interface IReadFile {
    List<Employee> readEmployeeFromFile(String filePath);
}
