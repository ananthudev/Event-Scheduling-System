//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
//	 * Approves the selected event by moving it to the 'approved' table.
//	 */
//	private void approveEvent(String department, String eventName, String hall, String startTime, String endTime) {
//	    try {
//	        // Insert the approved event into the 'approved' table
//	        String insertQuery = "INSERT INTO approved (department, eventname, hall, eventstart, eventend) VALUES (?, ?, ?, ?, ?)";
//	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
//	        insertStatement.setString(1, department);
//	        insertStatement.setString(2, eventName);
//	        insertStatement.setString(3, hall);
//	        insertStatement.setString(4, startTime);
//	        insertStatement.setString(5, endTime);
//	        insertStatement.executeUpdate();
//	        insertStatement.close();
//
//	        // Delete the event from the 'events' table
//	        String deleteQuery = "DELETE FROM events WHERE eventname = ?";
//	        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
//	        deleteStatement.setString(1, eventName);
//	        deleteStatement.executeUpdate();
//	        deleteStatement.close();
//
//	        populateTable();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	/**
//	 * Denies the selected event by moving it to the 'denied' table.
//	 */
//	private void denyEvent(String eventName) {
//	    try {
//	        // Retrieve the details of the denied event
//	        String selectQuery = "SELECT * FROM events WHERE eventname = ?";
//	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
//	        selectStatement.setString(1, eventName);
//	        ResultSet resultSet = selectStatement.executeQuery();
//
//	        if (resultSet.next()) {
//	            // Get the event details
//	            String department = resultSet.getString("department");
//	            String hall = resultSet.getString("hall");
//	            String eventStart = resultSet.getString("eventstart");
//	            String eventEnd = resultSet.getString("eventend");
//
//	            // Insert the denied event into the 'denied' table
//	            String insertQuery = "INSERT INTO denied (department, eventname, hall, eventstart, eventend) VALUES (?, ?, ?, ?, ?)";
//	            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
//	            insertStatement.setString(1, department);
//	            insertStatement.setString(2, eventName);
//	            insertStatement.setString(3, hall);
//	            insertStatement.setString(4, eventStart);
//	            insertStatement.setString(5, eventEnd);
//	            insertStatement.executeUpdate();
//	            insertStatement.close();
//	        }
//
//	        // Delete the event from the 'events' table
//	        String deleteQuery = "DELETE FROM events WHERE eventname = ?";
//	        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
//	        deleteStatement.setString(1, eventName);
//	        deleteStatement.executeUpdate();
//	        deleteStatement.close();
//
//	        resultSet.close();
//	        selectStatement.close();
//
//	        populateTable();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
