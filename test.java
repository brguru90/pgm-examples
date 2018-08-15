
import java.io.*;
import java.sql.*;

public class test {

    static Connection conn;
    static String url = "jdbc:mysql://localhost:3306/javadb";
    static String username = "root";
    static String password = "";
    static String sql;
    static Statement guru;
    static String x, y;
    static String a;

    public static void main(String args[]) {
        connect();
        while (true) {
            try {
                DataInputStream in = new DataInputStream(System.in);
                System.out.println("Choose the operation\n1.insert\t2.update\t3.delete\t4.view\t5.exit");
                int c = Integer.parseInt(in.readLine()); 
                switch (c) {
                    case 1:
                        insert();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        view();
                        break;
                    case 5:
                        disconnect();
                        System.exit(0);
                    default:
                        System.out.println("wrong option");
                }
                Runtime.getRuntime().exec("cls");
                System.out.flush(); 
            } catch (Exception e) {
            }
        }

    }

    public static void connect() {
        System.out.println("Connecting database...");
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        try {
            guru = conn.createStatement();
            sql = "create table guru"
                    + "("
                    + "Name varchar(20) primary key,"
                    + "mobno decimal(20)"
                    + ")";
            guru.executeUpdate(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            a = e.getMessage();
            System.out.println(a);
        }
    }

    public static void insert() throws IOException {
        try {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("Enter name");
            String name = in.readLine();
            System.out.println("Enter mobile no");
            String no = in.readLine();
            sql = "insert into guru values('" + name + "'," + no + ")";
            guru.executeUpdate(sql);
            System.out.println("insert success");
        } catch (IOException | SQLException e) {
            a = e.getMessage();
            System.out.println(a);
        }

    }

    public static void update() {
        try {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("Enter name");
            String name = in.readLine();
            System.out.println("Enter new mobile no");
            String no = in.readLine();
            sql = "update guru set mobno="+no+" where name='"+name+"'";
            guru.executeUpdate(sql);
            System.out.println("update success");
        } catch (IOException | SQLException e) {
            a = e.getMessage();
            System.out.println(a);
        }

    }

    public static void delete() {
        try {
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("Enter name");
            String name = in.readLine();
            sql = "delete from guru where name='" + name + "'";
            guru.executeUpdate(sql);
            System.out.println("delete success");
        } catch (IOException | SQLException e) {
            a = e.getMessage();
            System.out.println(a);
        }
    }

    public static void view() {
        try {
            sql = "select * from guru";
            ResultSet rs = guru.executeQuery(sql);
            while (rs.next()) {
                x = rs.getString(1);
                y = rs.getString(2);
                System.out.print(x + "\t" + y + "\n");
            }
        } catch (SQLException e) {
            a = e.getMessage();
            System.out.println(a);
        }

    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("unable to close connection");
        }
    }

}
