package ru.netology.web.sql;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInteraction {
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");
        return connection;
    }

    @SneakyThrows
    public static void deleteTables() {
        val authCodes = "DELETE FROM auth_codes";
        val cardTransactions = "DELETE FROM card_transactions";
        val cards = "DELETE FROM cards";
        val users = "DELETE FROM users";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            runner.update(conn, authCodes);
            runner.update(conn, cardTransactions);
            runner.update(conn, cards);
            runner.update(conn, users);
        }
    }
}
