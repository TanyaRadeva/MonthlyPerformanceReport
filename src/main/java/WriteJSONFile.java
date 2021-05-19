
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONFile {
    @SuppressWarnings("unchecked")
    public static void writeData() {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("name", "John Smith");
        employeeDetails.put("totalSales", 250);
        employeeDetails.put("salesPeriod", 10);
        employeeDetails.put("experienceMultiplier", 0.5);

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("name", "David Prowless");
        employeeDetails2.put("totalSales", 250);
        employeeDetails2.put("salesPeriod", 10);
        employeeDetails2.put("experienceMultiplier", 0.5);

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void writeReportDefinition() {
        //Definition
        JSONObject reportDefinition = new JSONObject();
        reportDefinition.put("topPerformersThreshold", 10);
        reportDefinition.put("useExperienceMultiplier", false);
        reportDefinition.put("periodLimit", 10);

        JSONObject definitionObject = new JSONObject();
        definitionObject.put("definition", reportDefinition);

        //Add employees to list
        JSONArray definitionList = new JSONArray();
        definitionList.add(definitionObject);

        //Write JSON file
        try (FileWriter file = new FileWriter("reportDefinition.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(definitionList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}