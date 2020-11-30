package back;

import back.h2Interaction.connection.DatabaseReader;
import back.point.Pipeline;
import back.point.PipelineActions;
import back.point.SearchingPoints;

import java.util.List;

public class LaunchBack {
    public String search(SearchingPoints s) {
        DatabaseReader databaseReader = new DatabaseReader();
        List<Pipeline> dataFromBase = databaseReader.getAllPipelines();
        PipelineActions pipelineActions = new PipelineActions();
        pipelineActions.parentAssigning(dataFromBase);
        int result = pipelineActions.searchRoute(s, dataFromBase);
        if (result == Integer.MAX_VALUE) {
            return "false";
        } else return "true; " + pipelineActions.searchRoute(s, dataFromBase);
    }
}
