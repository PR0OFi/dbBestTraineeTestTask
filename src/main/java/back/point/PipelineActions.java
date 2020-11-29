package back.point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        return calculateMinLengthIfExists(searchingPoints, collect);
    }

    private int calculateMinLengthIfExists(SearchingPoints searchingPoint, List<Pipeline> pipelines) {
        List<List<Pipeline>> existingPaths = new ArrayList<>();
        for (Pipeline currentPipe : pipelines) {
            deepSearch(searchingPoint, currentPipe, existingPaths);
        }
        return calculateMinLength(existingPaths);
    }

    private int calculateMinLength(List<List<Pipeline>> existingPath) {
        int min = Integer.MAX_VALUE;
        for (List<Pipeline> path : existingPath) {
            int sum = 0;
            for (Pipeline singlePipe : path) {
                sum += singlePipe.getLength();
            }
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }

    private void deepSearch(SearchingPoints searchingPoint,
                            Pipeline currentPipeline,
                            List<List<Pipeline>> exitingPaths) {
        if (currentPipeline.getEndpointId() == searchingPoint.getEndSearch()) {
            List<Pipeline> path = new ArrayList<>();
            Pipeline pipeline = currentPipeline;
            while (true) {
                path.add(pipeline);
                if (pipeline.getStartId() == searchingPoint.getStartSearch()){
                    break;
                }
                pipeline = pipeline.getParent();
            }
            exitingPaths.add(path);
            return;
        }
        for (Pipeline nextPipeline : currentPipeline.getChildList()) {
            deepSearch(searchingPoint, nextPipeline, exitingPaths);
        }

    }
}