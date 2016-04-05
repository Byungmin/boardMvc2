package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/testBoard");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	
	public int getListCount(){
		int count=0;
		
		try {
			
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){try{rs.close();}catch(SQLException sqle){sqle.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(SQLException sqle){sqle.printStackTrace();}}
		}
		
		
		return count;
	}
	
	
	
	
}
