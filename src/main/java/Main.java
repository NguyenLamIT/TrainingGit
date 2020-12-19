import file.Csv;
import file.IReadFile;
import model.Employee;

import java.util.List;

public class Main {
    public static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    public static void main(String[] args) {
        String filePath = RESOURCE_PATH + "input.txt";
        IReadFile readFile = new Csv();
        List<Employee> employees = readFile.readEmployeeFromFile(filePath);
        for (Employee employee : employees) {
            System.out.println("AGE: " + employee.getAge());
            System.out.println("Curent salary: " + employee.getSalary());
        }
    }
}
