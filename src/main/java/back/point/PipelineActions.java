package back.point;

import java.util.List;

public class PipelineActions {

    public void parentAssigning(List<Pipeline> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size() - 1; j++) {
                Pipeline pipeline = list.get(i);
                if (pipeline.getEndpointId() == list.get(j).getStartId()) {
                    list.get(j).setParent(pipeline);
                }
            }
        }
    }

    public int searchRoute(SearchingPoints searchingPoints, List<Pipeline> pipelines) {
        int sum = 0;
        for (Pipeline p : pipelines) {
            if (searchingPoints.getStartSearch() == p.getStartId() && searchingPoints.getEndSearch() == p.getEndpointId()) {
                return p.getLength();
            } else {
                if (p.getStartId() == searchingPoints.getStartSearch()) {
                    sum = deepSearch(searchingPoints, p);
                }
            }
        }
        return sum;
    }

    private static int deepSearch(SearchingPoints searchingPoints, Pipeline current) {
        int sum = 0;
        if (current.getEndpointId() == searchingPoints.getEndSearch()) {
            return current.getLength();
        } else {
            for (Pipeline p : current.getChildList()) {
                sum += current.getLength() + deepSearch(searchingPoints, p);
            }
        }
        return sum;
    }
}