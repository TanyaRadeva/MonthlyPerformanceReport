import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Definition {
    private Long topPerformersThreshold;
    private boolean useExperienceMultiplier;
    private Long periodLimit;

    public Definition(String filePath) {
        readReportDefinition(filePath);
    }

    public Long getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    public boolean isUseExperienceMultiplier() {
        return useExperienceMultiplier;
    }

    public Long getPeriodLimit() {
        return periodLimit;
    }

    @SuppressWarnings("unchecked")
    private void readReportDefinition(String filePath) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        //try (FileReader reader = new FileReader("reportDefinition.json")) {
        try (FileReader reader = new FileReader(filePath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray definitionList = (JSONArray) obj;
            //System.out.println(definitionList);

            //Iterate over definition array
            definitionList.forEach(repDef -> parseReportDefinition((JSONObject) repDef));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseReportDefinition(JSONObject reportDefinition) {
        //Get report definition
        JSONObject definitionObject = (JSONObject) reportDefinition.get("definition");

        //Get reportDefinition topPerformersThreshold
        Long topPerformersThreshold = (Long) definitionObject.get("topPerformersThreshold");

        //Get reportDefinition useExperienceMultiplier
        Boolean useExperienceMultiplier = (Boolean) definitionObject.get("useExperienceMultiplier");

        //Get reportDefinition periodLimit
        Long periodLimit = (Long) definitionObject.get("periodLimit");

        this.topPerformersThreshold = topPerformersThreshold;
        this.useExperienceMultiplier = useExperienceMultiplier;
        this.periodLimit = periodLimit;
    }
}
