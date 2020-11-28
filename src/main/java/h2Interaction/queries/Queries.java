package h2Interaction.queries;

public interface Queries {
    //
    String CREATE_PIPELINE = "INSERT INTO " + Constants.TABLE_NAME + " " + " VALUES (?, ?, ?)";
    //
    String SELECT_ALL = "SELECT * FROM " + Constants.TABLE_NAME;
    //
    String CREATE_DATA_BASE = "CREATE TABLE " + Constants.TABLE_NAME +  "(startPointID INT, endpointID INT, length INT)";
    String DELETE_DATA_BASE = "DROP DATABASE $tableName";
    String DROP_TABLE_IF_THIS_EXIST = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME;
}
