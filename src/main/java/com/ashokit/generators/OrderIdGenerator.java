//package com.ashokit.generators;
//
//import lombok.Setter;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
////use this method when you set OrderIdGenerator.setPrefix("EMP_"); in application.class
//public class OrderIdGenerator implements IdentifierGenerator {
//
//    // Setter for updating the prefix dynamically
//    // Dynamic prefix source
//    @Setter
//    private static String prefix = "EMP_"; // Default value
//
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) {
//        String suffix = "";
//
//        try (Connection connection = session.getJdbcConnectionAccess().obtainConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "SELECT MAX(CAST(SUBSTRING(emp_id, ?) AS UNSIGNED)) FROM emp_tbl WHERE emp_id LIKE ?")) {
//
//            // Dynamically calculate starting index based on prefix length
//            int substringStart = prefix.length() + 1;
//
//            preparedStatement.setInt(1, substringStart);
//            preparedStatement.setString(2, prefix + "%");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int maxId = resultSet.getInt(1); // Extract the numeric part of the ID
//                suffix = String.valueOf(maxId + 1); // Increment the numeric part
//            } else {
//                suffix = "1"; // Default to 1 if no matching records exist
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return prefix + suffix; // Combine the dynamic prefix with the numeric part
//    }
//}

//use this method when you don't set OrderIdGenerator.setPrefix("EMP_"); in application.class
//that time if you change String prefix = "EMP_"; then you need to change
//SELECT MAX(CAST(SUBSTRING(emp_id, 5)-> this 5 and this 5 is calculate formula is
// prefix.length()+1 and then number put into this by exchanging by 5
// Example if here i use String prefix = "OD_"; then i change number by 5 to 4

package com.ashokit.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "EMP_"; // Prefix for the ID
        String suffix = "";

        try (Connection connection = session.getJdbcConnectionAccess().obtainConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT MAX(CAST(SUBSTRING(emp_id, 5) AS UNSIGNED)) FROM emp_tbl")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int maxId = resultSet.getInt(1); // Extract the numeric part
                suffix = String.valueOf(maxId + 1); // Increment it
            } else {
                suffix = "1"; // Default to EMP_1 if no records exist
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prefix + suffix; // Combine prefix and incremented numeric part
    }
}