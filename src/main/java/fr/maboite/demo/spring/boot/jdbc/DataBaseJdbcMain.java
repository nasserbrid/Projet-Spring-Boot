package fr.maboite.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import fr.maboite.demo.spring.boot.model.Company;

/**
 * Classe utilisant JDBC pour communiquer avec la base de données :
 * long et coûteux.
 */
public class DataBaseJdbcMain {

    public static void main(String[] args) {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/prf_spring",
                connectionProps)){
            DataBaseJdbcMain databaseJdbcMain = new DataBaseJdbcMain();
            databaseJdbcMain.launchQueries(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database ", e);
        }

    }

    public void launchQueries(Connection con) throws SQLException {
        String dropTableQuery = "drop table IF EXISTS BIG_COMPANY ";
        String createTableQuery = "create table BIG_COMPANY ("
                + "       ID bigint not null,"
                + "        NAME varchar(255),"
                + "        SIRET varchar(255),"
                + "        primary key (ID) "
                + "    )";
        String insertQuery = "insert into COMPANY(ID, NAME, SIRET) VALUES (1, 'bigCorp', 'siret1')";
        String insertQuery2 = "insert into COMPANY(ID, NAME, SIRET) VALUES (2, 'smallCorp', 'siret2')";
        String selectQuery = "select ID, NAME from COMPANY";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(dropTableQuery);
            stmt.executeUpdate(createTableQuery);
            stmt.executeUpdate(insertQuery);
            stmt.executeUpdate(insertQuery2);
            // du code ...
            ResultSet resultSet = stmt.executeQuery(selectQuery);
            while (resultSet.next()) {
                String nameDeLaCompany1 = resultSet.getString("NAME");
                Integer idCompany1 = resultSet.getInt("ID");
                System.out.println("L'id de la company vaut : " + idCompany1);
                System.out.println("Le nom de la company vaut : " + nameDeLaCompany1);

                Company c = new Company();
                c.setName(nameDeLaCompany1);
                c.setId(idCompany1);
            }
        }
    }

}