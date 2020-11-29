package back.parser;

import back.point.Pipeline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVtoPipelineObject {
    public List<Pipeline> readPipelinesFromCSV(String filename) {
        List<Pipeline> pipelines = new ArrayList<>();
        File file = new File(this.getClass().getClassLoader().getResource(filename).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] numbers = line.split("\\s*[,;]\\s*");
                int[] data = new int[3];
                for (int i = 0; i < numbers.length; i++) {
                    data[i] = Integer.parseInt(numbers[i]);
                }
                Pipeline pipeline = createPipeline(data);
                pipelines.add(pipeline);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pipelines;
    }

    private static Pipeline createPipeline(int[] data) {
        int startId = data[0];
        int endPointId = data[1];
        int length = data[2];

        return new Pipeline(startId, endPointId, length);
    }
}
