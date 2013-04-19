package db.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class MySQLDatabase {
    private static MySQLDatabase instance=new MySQLDatabase();
    
    private MysqlConnectionPoolDataSource pool;
    private String sequenceTable;
    private boolean sequenceSupported;
    
    private MySQLDatabase() { 
        pool = new MysqlConnectionPoolDataSource();
        pool.setDatabaseName("2nmct1xaviervanvarenberg");
        pool.setServerName("localhost");
        pool.setUser("root");
        pool.setPassword("luna1991");
        pool.setPort(3306);        
        sequenceSupported = false;
    }
    
    public static MySQLDatabase getInstance(){
        return instance;
    }
    
    //openen connectie
    public  Connection getConnection() throws SQLException{
        return pool.getConnection();
    }
    /**
     * Cre�ert een nieuw id voor een tabel en kolom, indien
     * een Sequence gebruikt wordt, wordt de tabel en kolom genegeerd.
     */
    public int createNewID(Connection conn, String tabel,String kolom){
        try{
            if ( sequenceSupported){
                String sql = "select nextval('"+sequenceTable+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if ( rs.next()){
                    return rs.getInt(1);
                }
                return -1;
            }else{
                if ( conn != null && !conn.isClosed()){
                    String sql = "select max("+kolom+") as maxid from "+tabel;
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if ( rs.next() ){
                        int maxid = rs.getInt("maxid");
                        return maxid+1;
                    }
                    return -1;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }
    
    /**
     * Deze methode kan gebruikt worden om te testen wat er precies in een
     * ResultSet te vinden is.
     * Let op : De ResultSet kan je daarna niet meer gebruiken!
     */
    public void printResultSet(ResultSet rs){
        try{
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i=1;i <= rsmd.getColumnCount();i++){
                System.out.print(rsmd.getColumnLabel(i));
                System.out.print(",");
            }
            System.out.println();
            while(rs.next()){
                for ( int i = 1 ; i <= rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i));
                    System.out.print(",");
                }
                System.out.println();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)throws Exception{
        System.out.println("Execute this main method to test the connection !");
        MySQLDatabase db = MySQLDatabase.getInstance();
        Connection c = db.getConnection();
        //int newid= db.createNewID(c,"player","id");
        //System.out.println("Id : " + newid);
        c.close();
        
    }
}