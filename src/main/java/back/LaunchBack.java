package back;

import back.h2Interaction.connection.Procedure;
import back.h2Interaction.queries.Constants;
import back.parser.CSVtoPipelineObject;
import back.point.Pipeline;
import back.point.PipelineActions;
import back.point.SearchingPoints;

import java.util.List;

public class LaunchBack {
    public String search(SearchingPoints s) {
        CSVtoPipelineObject csVtoPipelineObject = new CSVtoPipelineObject();
        List<Pipeline> dataFromFile = csVtoPipelineObject.readPipelinesFromCSV(Constants.FILE_PATH);
        Procedure procedure = new Procedure();
        List<Pipeline> dataFromBase = procedure.processingToGiveAllUsers(dataFromFile);
        PipelineActions pipelineActions = new PipelineActions();
        pipelineActions.parentAssigning(dataFromBase);
        int result = pipelineActions.searchRoute(s, dataFromBase);
        if (result == Integer.MAX_VALUE) {
            return "false";
        } else return "true; " + pipelineActions.searchRoute(s, dataFromBase);
    }
}
