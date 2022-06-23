import java.sql.*;

public class Database {
    private String url = "jdbc:mysql://localhost/dbBiodata";
    private String user = "root";
    private String password = "";

    private Connection conn;
    private Statement stm;

    Database() throws SQLException {
        conn = DriverManager.getConnection(this.url, this.user, this.password);
        stm = conn.createStatement();
    }

    ResultSet loginAdm(String username, String password) throws SQLException {
        ResultSet data = this.stm
                .executeQuery("SELECT * FROM admin WHERE username='" + username + "' AND username='" + password + "'");
        return data;
    }

    ResultSet getAllMhs() throws SQLException {
        ResultSet data = this.stm.executeQuery("SELECT * FROM data");
        return data;
    }

    void insertMhs(String nim, String nama, String jk, String alamat, String prodi, String tgl_lahir)
            throws SQLException {
        this.stm
                .executeUpdate(
                        "INSERT INTO data (nim, nama, jk, alamat, prodi, tgl_lahir) VALUES('" + nim + "','" + nama
                                + "','" + jk
                                + "','" + alamat + "','" + prodi + "','" + tgl_lahir + "')");
    }

    void updateMhs(String nim, String nama, String jk, String alamat, String prodi, String tgl_lahir)
            throws SQLException {
        stm.executeUpdate("UPDATE data SET nama='" + nama + "', jk='" + jk + "', alamat='" + alamat + "', prodi='"
                + prodi + "', tgl_lahir='" + tgl_lahir + "' WHERE nim='"
                + nim + "' ");
    }

    void deleteMhs(String nim) throws SQLException {
        stm.executeUpdate("DELETE FROM data WHERE nim='" + nim + "' ");
    }

    ResultSet cariMhs(String nama) throws SQLException {
        ResultSet data = this.stm.executeQuery("SELECT * FROM data WHERE nama LIKE '%" + nama + "%'");
        return data;
    }

    void close() throws SQLException {
        stm.close();
        conn.close();
    }
}
