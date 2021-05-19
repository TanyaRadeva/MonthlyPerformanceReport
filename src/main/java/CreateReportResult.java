import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateReportResult {
    private List<ResultEmployee> resultList = new ArrayList<>();
    private double maxScore;
    private double topScore;

    public CreateReportResult(String filePath,
                              List<Employee> employeesList,
                              Definition definition) {
        createReport(employeesList, definition, filePath);
    }

    private void createReport(List<Employee> employeesList,
                              Definition definition, String filePath) {
        StringBuilder sbResult = new StringBuilder();
        sbResult.append("Result").append(System.lineSeparator());
        sbResult.append("Name").append(",").append("Score").append(System.lineSeparator());
        maxScore = generateScore(employeesList, definition, resultList);
        topScore = maxScore * ((100 - definition.getTopPerformersThreshold())/(double)100);

        for (ResultEmployee result : resultList) {
            if (result.getScore()  >= topScore) {
                sbResult.append(result.toString());
            }
        }
        insertToFile(filePath, sbResult.toString());
    }

    private double generateScore(List<Employee> employees,
                                 Definition definition,
                                 List<ResultEmployee> resultLst) {
        double score;
        double maxScore = 0;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalesPeriod() <= definition.getPeriodLimit()) {
                score = employees.get(i).getTotalSales() / employees.get(i).getSalesPeriod();
                if (definition.isUseExperienceMultiplier()) {
                    score = score * employees.get(i).getExperienceMultiplier();
                }
                if (maxScore < score) {
                    maxScore = score;
                }
                ResultEmployee resultEmpl = new ResultEmployee(employees.get(i).getName(), score);
                resultLst.add(resultEmpl);
            }
        }
        resultLst.sort(ResultEmployee::compareTo);
        return maxScore;
    }

    private void insertToFile(String filePath, String result) {
        //Write JSON file
        try (FileWriter file = new FileWriter(filePath)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(result);
            file.flush();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

