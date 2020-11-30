package back;

import back.h2Interaction.connection.DatabaseActions;
import back.point.Pipeline;
import back.point.PipelineActions;
import back.point.SearchingPoints;

import java.util.List;

public class MakeAction {
    PipelineActions pipelineActions = new PipelineActions();
    DatabaseActions databaseActions = new DatabaseActions();
    List<Pipeline> receivedPipelines;

    public MakeAction() {
        receivedPipelines = databaseActions.getAllPipelines();
        PipelineActions pipelineActions = new PipelineActions();
        pipelineActions.parentAssigning(receivedPipelines);
    }

    public String search(SearchingPoints s) {
        int result = pipelineActions.searchRoute(s, receivedPipelines);
        if (result == Integer.MAX_VALUE) {
            return "false";
        } else return "true; " + pipelineActions.searchRoute(s, receivedPipelines);
    }
}
