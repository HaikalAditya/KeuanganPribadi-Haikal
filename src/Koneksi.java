import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection mysqlkonek;

    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        if (mysqlkonek == null) {
            try {
                String DB = "jdbc:mysql://localhost:3306/db_keuangan_pribadi"; // URL database
                String user = "root"; // Nama pengguna database
                String pass = ""; // Kata sandi database
                
                // Inisialisasi koneksi
                mysqlkonek = DriverManager.getConnection(DB, user, pass);
            } catch (SQLException e) {
                // Cetak pesan error ke konsol untuk debugging
                System.err.println("Koneksi gagal: " + e.getMessage());
                throw new SQLException("Gagal menghubungkan ke database.", e);
            }
        }
        return mysqlkonek;
    }
}
