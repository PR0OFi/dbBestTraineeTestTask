package back.point;

public class SearchingPoints {
    private final int startSearch;
    private final int endSearch;

    public SearchingPoints(int startSearch, int endSearch) {
        this.startSearch = startSearch;
        this.endSearch = endSearch;
    }

    public int getStartSearch() {
        return startSearch;
    }

    public int getEndSearch() {
        return endSearch;
    }
}
