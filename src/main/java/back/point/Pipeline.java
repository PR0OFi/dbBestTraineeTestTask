package back.point;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {
    private Pipeline parent;
    private final int startId;
    private final int endpointId;
    private final int length;
    private List<Pipeline> childList = new ArrayList<>();

    public Pipeline(int startId, int endpointId, int length) {
        this.startId = startId;
        this.endpointId = endpointId;
        this.length = length;
    }

    //GETTERS AND SETTERS
    public int getStartId() {
        return startId;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public int getLength() {
        return length;
    }

    public void addChild(Pipeline child) {
        if (child != null) {
            this.childList.add(child);
            child.setParent(this);
        }
    }

    public Pipeline getParent() {
        return parent;
    }

    public void setParent(Pipeline parent) {
        if (parent != null) {
            this.parent = parent;
        }
    }

    public List<Pipeline> getChildList() {
        return childList;
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
