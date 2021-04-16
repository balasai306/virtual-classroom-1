package com.VirtualClassroom.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Closing;
import util.Connector;
import util.myExceptions;

public class ViewMarksDao {
	String sqlView = "select * from subject ";
			Closing close = new Closing();

	public List viewMarks() {
		Connector connection = new Connector();
		Connection con = null;
		Statement stmt = null;

		ResultSet rs = null;
		List<String> Students = new ArrayList();
		try {
			con = connection.getConnector();
			stmt = con.prepareStatement(sqlView);

			rs = stmt.executeQuery(sqlView);
			while (rs.next()) {
				String details = "";
				for (int i = 1; i <= 4; i++) {
					details = details + rs.getString(i) + " , ";

				}
				Students.add(details);

				System.out.println();
			}

		} catch (myExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close.closeConnection(rs);
			close.closeConnection(stmt);
			close.closeConnection(con);

		}
		return Students;

	}
}
