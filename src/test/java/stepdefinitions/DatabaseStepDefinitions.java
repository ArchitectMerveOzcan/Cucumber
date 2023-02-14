package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;
import java.sql.SQLException;

public class DatabaseStepDefinitions {
    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
//        creating database connections using database utility class
        DBUtils.createConnection();
    }
    @Given("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String column, String table) {
//        String query = "SELECT * FROM jhi_user";//HARD CODED
        String query = "SELECT "+column+" FROM "+table+"";//DYNAMIC QUERY
//        Running the query using util class
        DBUtils.executeQuery(query);
    }
    @Then("user reads all the column {string} data")
    public void user_reads_all_the_column_data(String column) throws SQLException {
//        Using result set, get teh objects from the database
        DBUtils.getResultset().next();//going to the next row
        Object object1 = DBUtils.getResultset().getObject(column);
        System.out.println(object1);
        System.out.println(object1);
    }
}