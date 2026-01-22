package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	
	//Method for adding a student
	public void addStudent(Student student) {
		
		String sql = "INSERT INTO students (name,email,course,marks) VALUES (?,?,?,?);";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setString(3, student.getCourse());
			pstmt.setInt(4, student.getMarks());
			
			int rowsInserted = pstmt.executeUpdate();
			
			if(rowsInserted>0) {
				System.out.println("Student added successfully.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Method for viewing students data
	public void viewAllStudents() {
		
		String sql = "SELECT * FROM students;";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			System.out.println("\n--- Student List ---");
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String course = rs.getString("Course");
				int marks = rs.getInt("Marks");
				
				System.out.println(
						id+" | "+
						name+" | "+
						email+" | "+
						course+" | "+
						marks
				);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Method for Updating Students' data
	public void updateStudent(int id,String name,String email,String course,int marks) {
		
		String sql = "UPDATE students SET Name=?, Email=?, Course=?, Marks=? WHERE ID=?;";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, course);
			pstmt.setInt(4, marks);
			pstmt.setInt(5, id);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated>0) {
				System.out.println("Student updated successfully.");
			}
			else {
				System.out.println("Student not found with ID: "+id);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Method For Deleting Students' Data
	public void deleteStudent(int id) {
		
		String sql="DELETE FROM students WHERE ID=?;";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, id);
			
			int rowsDeleted = pstmt.executeUpdate();
			
			if(rowsDeleted>0) {
				System.out.println("Student deleted successfully.");
			}
			else {
				System.out.println("Student not found with ID: "+id);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
