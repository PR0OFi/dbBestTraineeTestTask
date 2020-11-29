package back.point;

import back.h2Interaction.connection.H2Actions;

import java.util.List;

public class Procedure {

    public static void main(String[] args) {
        H2Actions connection = new H2Actions();
        connection.connectToDb();
        List<Pipeline> pipelines = connection.readAll(connection.connection);
        parentAssigning(pipelines);
        SearchPoints searchPoints = new SearchPoints(1, 5);
        int i = searchRoute(searchPoints, pipelines);
        System.out.println(i);
        //deepSearch(mainPipeline, searchPoints, pipelines);
    }

    public static void parentAssigning(List<Pipeline> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size() - 1; j++) {
                if (list.get(i).getEndpointId() == list.get(j).getStartId()) {
                    list.get(j).setParent(list.get(i));
                }
            }
        }
    }

    public static int searchRoute(SearchPoints searchPoints, List<Pipeline> pipelines) {
        int sum = 0;
        for (Pipeline p : pipelines) {
            if (searchPoints.getStartSearch() == p.getStartId() && searchPoints.getEndSearch() == p.getEndpointId()) {
                return p.getLength();
            } else {
                if (p.getStartId() == searchPoints.getStartSearch()) {
                    sum = deepSearch(searchPoints, p);
                }
            }
        }
        return sum;
    }

    public static int deepSearch(SearchPoints searchPoints, Pipeline current) {
        int sum = 0;
        if (current.getEndpointId() == searchPoints.getEndSearch()) {
            return current.getLength();
        } else {
            for (Pipeline p : current.getChildList()) {
                sum += current.getLength() + deepSearch(searchPoints, p);
                break;
            }
        }
        return sum;
    }
}