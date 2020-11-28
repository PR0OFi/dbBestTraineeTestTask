package parser;

import point.Pipeline;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVtoPipelineObject {
    public static void main(String[] args) {
        readPipelinesFromCSV("D:\\Projects\\demo\\dbBestTraineeTestTask\\src\\main\\resources\\Data.csv");
    }

    public static List<Pipeline> readPipelinesFromCSV(String filename) {
        List<Pipeline> pipelines = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                String[] numbers = line.split("\\s*,\\s*");
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
