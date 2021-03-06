package com.cardlinesrl.util;

import com.cardlinesrl.virtualline.model.ParticipantBalance;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VirtuallineConnection {

    final static Logger logger = Logger.getLogger(ClerpConnection.class);

    private static Connection conn;

    public void openConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(ConnectionData.VL_URL, ConnectionData.VL_USER, ConnectionData.VL_PASS);

        } catch (ClassNotFoundException ex) {
            logger.debug(ex);
        } catch (SQLException ex) {
            logger.debug(ex);
        }
    }

    public void closeConnection() {

        try {

            conn.close();

        } catch (SQLException ex) {
            logger.debug(ex);
        }
    }

    public List<ParticipantBalance> getParticipantsNegativeBalance() {

        List <ParticipantBalance> participants = new ArrayList<>();

        String query = "SELECT PARTICIPANT_ID participant_id, P.name participant_name, B.balance participant_balance " +
                "FROM balance_cache B " +
                "INNER JOIN participant P on (P.account = B.account) " +
                "HAVING participant_balance < 0";

        try (PreparedStatement st = conn.prepareStatement(query)) {

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                participants.add(new ParticipantBalance(
                        rs.getInt("participant_id"),
                        rs.getString("participant_name").trim(),
                        rs.getBigDecimal("participant_balance"))
                );
            }

        } catch (SQLException ex) {
            logger.debug(ex);
        }

        return participants;
    }

}
