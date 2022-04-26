package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.model.Batch;
import com.management.model.Subject;
/**
 * @author Suyash verma
 *
 */
public class BatchDAO {
	public static int getBatchId() {
		System.out.println("* * * getBactchId method from BatchDAO");
		int batchID = 0;
		try{
			Connection connection = DBConnection.createConnection();
			PreparedStatement ps=connection.prepareStatement("SELECT MAX(batch_id) AS last_id FROM batch1");
			ResultSet rs=ps.executeQuery();
			System.out.println("batch ID query executed");
			if(rs.next()){
				batchID = rs.getInt("last_id");
				System.out.println("Batch Id previous = " + batchID);
				batchID++;
			}
		}catch(Exception e){System.out.println(e);}
		return batchID;
	}
	
	public static int[] extractBatchSubjectsByID(int batchID) throws ClassNotFoundException, SQLException{
		String extract_batch_details = "SELECT * FROM batch1 WHERE batch_id = " + batchID;
		
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps=connection.prepareStatement(extract_batch_details);
		ResultSet rs=ps.executeQuery();
		int subID[] = new int[8];
		int i = 0;
	    
		if(rs.next()){
			for(int j=2;j<=9;j++) {
				subID[i] = rs.getInt(j);
				i++;
			}
		}
		return subID;
	}
	
	public int extractBatchDetails() throws ClassNotFoundException, SQLException{
		String extract_batch_details = "SELECT * FROM batch1";
		
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps=connection.prepareStatement(extract_batch_details);
		ResultSet rs=ps.executeQuery();
		Batch array[] = new Batch[8];
		int i = 0;
	
		while(rs.next()){
			array[i].createBatchID(rs.getInt(i));
			Subject subs[] = new Subject[8];
			for(int j=0;j<8;j++) {
				subs[j].setSubjectID(rs.getInt(j));
				subs[j].setName(subs[j].getName());
			}
		}
		return i;
	}
	
	public static int createBatch(Batch batch) throws ClassNotFoundException, SQLException{
		System.out.println("* * * *BatchDAO.createBatch method started");
		String insert_batch = "INSERT INTO batch1" + 
	    " (batch_id,subject_id1,subject_id2,subject_id3,subject_id4,subject_id5,subject_id6,subject_id7,subject_id8)"+
        " VALUES (?,?,?,?,?,?,?,?,?)";
		
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(insert_batch);
		final int[] sid = batch.getSubjectIDs();
		/*
		System.out.println(batch.getBatchID());
		for(int i=0;i<sid.length;i++) {
			System.out.println(sid[i]);
		}
		*/
		ps.setInt(1,batch.getBatchID());
		ps.setInt(2,sid[0]);
		ps.setInt(3,sid[1]);
		ps.setInt(4,sid[2]);
		ps.setInt(5,sid[3]);
		ps.setInt(6,sid[4]);
		ps.setInt(7,sid[5]);
		ps.setInt(8,sid[6]);
		ps.setInt(9,sid[7]);
		
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		connection.close();
		System.out.println("* * * *BatchDAO.createBatch method ended");
		return result;
	}
	
	public static int deleteBatch(int batchID) throws ClassNotFoundException, SQLException
	{
		String insert_batch = "DELETE FROM batch1 WHERE batch_id = " + batchID;
				
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(insert_batch);
				
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		connection.close();
		return result;
	}
	
	public static int updateBatch(int batchID, int[] subID) throws ClassNotFoundException, SQLException{
		System.out.println("* * * *update batch method started");
		String query = "UPDATE batch1 SET subject_id1 = "+subID[0]+", subject_id2 = "+subID[1]+", " 
				+ "subject_id3 = "+subID[2]+",subject_id4 = "+subID[3]+",subject_id5 ="+subID[4]+",  "
				+ "subject_id6 = "+subID[5]+", subject_id7 = "+subID[6]+", "
				+ "subject_id8 = "+subID[7]
				+ " WHERE batch_id=" + batchID ;
		
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(query);
	
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		connection.close();
		System.out.println("* * * *update batch method ended");
		return result;
	}
}
