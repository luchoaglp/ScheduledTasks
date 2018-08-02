package com.cardlinesrl.util;

import com.cardlinesrl.virtualline.model.ParticipantBalance;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Calendar;
import java.util.List;


public class ClerpConnection {

    final static Logger logger = Logger.getLogger(ClerpConnection.class);

    private static Connection conn;

    public void openConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(ConnectionData.CLERP_URL, ConnectionData.CLERP_USER, ConnectionData.CLERP_PASS);

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

    public void getParticipantsNegativeBalance(List<ParticipantBalance> participants) {

        Date currentDate = new Date(Calendar.getInstance().getTime().getTime());

        for(ParticipantBalance participant : participants) {

            String query = "SELECT * FROM virtual_participants " +
                    "WHERE virtual_id = ?";

            try (PreparedStatement st = conn.prepareStatement(query)) {

                st.setInt(1, participant.getParticipantId());

                ResultSet rs = st.executeQuery();

                if(!rs.next()) {

                    query = "INSERT INTO virtual_participants " +
                            "VALUES (?, ?)";

                    try(PreparedStatement st2 = conn.prepareStatement(query)) {

                        st2.setInt(1, participant.getParticipantId());
                        st2.setString(2, participant.getParticipantName());

                        st2.execute();
                    }
                }

                query = "INSERT INTO virtual_balances " +
                        "VALUES (NULL, ?, ?, ?)";

                try(PreparedStatement st2 = conn.prepareStatement(query)) {

                    st2.setBigDecimal(1, participant.getParticipantBalance());
                    st2.setDate(2, currentDate);
                    st2.setInt(3, participant.getParticipantId());

                    st2.execute();
                }

            } catch (SQLException ex) {
                logger.debug(ex);
            }
        }
    }

}
