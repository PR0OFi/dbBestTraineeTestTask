package back.point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipelineActions {

    public void parentAssigning(List<Pipeline> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                Pipeline pipeline = list.get(i);
                if (pipeline.getEndpointId() == list.get(j).getStartId()) {
                    pipeline.addChild(list.get(j));
                }
            }
        }
    }

    public int searchRoute(SearchingPoints searchingPoints, List<Pipeline> allPipelines) {
        List<Pipeline> collect = allPipelines.stream()
                .filter(p -> p.getStartId() == searchingPoints.getStartSearch())
                .collect(Collectors.toList());

        return calculateMinLengthIfExists(searchingPoints.getEndSearch(), collect);
    }

    private int calculateMinLengthIfExists(int endID, List<Pipeline> pipelines) {
        List<List<Pipeline>> existingPaths = new ArrayList<>();
        for (Pipeline currentPipe : pipelines) {
            List<Pipeline> path = new ArrayList<>();
            List<Pipeline> existingPath = deepSearch(endID, currentPipe, path);
            if (existingPath != null) {
                existingPaths.add(existingPath);
            }
        }
        return calculateMinLength(existingPaths);
    }

    private int calculateMinLength(List<List<Pipeline>> existingPath) {
        return
                existingPath.stream()
                .flatMap(pipelineList -> pipelineList.stream())
                .mapToInt(Pipeline::getLength)
                .sum();
    }

    private List<Pipeline> deepSearch(int endID, Pipeline currentPipeline, List<Pipeline> path) {
        path.add(currentPipeline);
        if (currentPipeline.getEndpointId() == endID) {
            return path;
        }
        for (Pipeline nextPipeline : currentPipeline.getChildList()) {
            deepSearch(endID, nextPipeline, path);
        }
        return null;
    }
}