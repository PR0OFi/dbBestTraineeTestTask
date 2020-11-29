package back;

import back.h2Interaction.connection.Procedure;
import back.h2Interaction.queries.Constants;
import back.parser.CSVtoPipelineObject;
import back.point.Pipeline;
import back.point.PipelineActions;

import java.util.List;

public class LaunchBack {
    public static void main(String[] args) {
        CSVtoPipelineObject csVtoPipelineObject = new CSVtoPipelineObject();
        List<Pipeline> dataFromFile = csVtoPipelineObject.readPipelinesFromCSV(Constants.FILE_PATH);
        Procedure procedure = new Procedure();
        List<Pipeline> dataFromBase = procedure.processingToGiveAllUsers(dataFromFile);
        PipelineActions pipelineActions = new PipelineActions();
        pipelineActions.parentAssigning(dataFromBase);

        for(Pipeline p : dataFromBase) {
            System.out.println( p.getChildList());
        }
        //----------------------------

    }
}
