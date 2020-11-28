package point;

public class Pipeline {
    private int startId;
    private int endpointId;
    private int length;

    public Pipeline(int startId, int endpointId, int length) {
        this.startId = startId;
        this.endpointId = endpointId;
        this.length = length;
    }

    public int getStartId() {
        return startId;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Pipeline{" +
                "startId=" + startId +
                ", endpointId=" + endpointId +
                ", length=" + length +
                '}';
    }
}
