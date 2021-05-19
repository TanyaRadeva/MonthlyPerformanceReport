import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadEmployeesJSONFile {
    private List<Employee> employees;

    public ReadEmployeesJSONFile(String filePath) {
        employees = new ArrayList<>();
        readEmployeeData(filePath);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @SuppressWarnings("unchecked")
    private void readEmployeeData(String filePath) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        //try (FileReader reader = new FileReader("employees.json")) {
        try (FileReader reader = new FileReader(filePath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            //System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseEmployeeObject(JSONObject empl) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) empl.get("employee");

        //Get employee name
        String name = (String) employeeObject.get("name");

        //Get employee totalSales
        Long totalSales = (Long) employeeObject.get("totalSales");

        //Get employee salesPeriod
        Long salesPeriod = (Long) employeeObject.get("salesPeriod");

        //Get employee experienceMultiplier
        Double experienceMultiplier = (Double) employeeObject.get("experienceMultiplier");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setTotalSales(totalSales);
        employee.setSalesPeriod(salesPeriod);
        employee.setExperienceMultiplier(experienceMultiplier);
        employees.add(employee);
    }

}
