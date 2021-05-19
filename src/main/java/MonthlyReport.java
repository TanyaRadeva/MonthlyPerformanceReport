import java.util.*;

public class MonthlyReport {

    public static void main(String[] args) {
        //Create JSON files - just for tests purposes
//      WriteJSONFile.writeData();
//      WriteJSONFile.writeReportDefinition();

        String definitionFile = "";
        String dataFile = "";
        String reportFile = "";

        if (args.length < 3) {
            System.out.println();
            System.out.println("Usage:");
            System.out.println("----------------------");
            System.out.println("java -jar MonthlyPerformanceReport dataEmployeesFileName definitionFileName monthlyReportFileName");
            System.out.println();
            System.out.println();
            return;
        } else {
            dataFile = args[0];
            definitionFile = args[1];
            reportFile = args[2];
        }

        //Set file names - just for tests purposes
        // Remove after arguments preparing!!!
//        if (dataFile.equals("")) {
//            dataFile = "dataEmployees.json";
//        }
//        if (definitionFile.equals("")) {
//            definitionFile = "reportDefinition.json";
//        }
//        if (reportFile.equals("")) {
//            reportFile = "monthlyReport.txt";
//        }

        Definition definition = new Definition(definitionFile);
        ReadEmployeesJSONFile employees = new ReadEmployeesJSONFile(dataFile);
        List<Employee> employeesList = employees.getEmployees();
        CreateReportResult report = new CreateReportResult(reportFile, employeesList, definition);
    }
}
