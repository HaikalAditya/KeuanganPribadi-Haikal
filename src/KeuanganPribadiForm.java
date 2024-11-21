
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class KeuanganPribadiForm extends javax.swing.JFrame {

    /**
     * Creates new form KeuanganPribadiForm
     */
    public KeuanganPribadiForm() {
        initComponents();
    }

 public class TransaksiHandler {

    // Metode untuk memuat data ke JTable
    public void loadTable(javax.swing.JTable table) {
        // Ambil model tabel dari JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Hapus semua baris yang ada di tabel

        try {
            // Dapatkan koneksi ke database
            Connection conn = Koneksi.getConnection();

            // Query SQL untuk mengambil semua data dari tabel transaksi
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Loop untuk menambahkan setiap baris data dari ResultSet ke model JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getDate("tanggal"),      // Ambil data tanggal
                    rs.getString("jenis"),     // Ambil data jenis transaksi
                    rs.getString("kategori"),  // Ambil data kategori
                    rs.getDouble("nominal"),   // Ambil data nominal
                    rs.getString("keterangan") // Ambil data keterangan
                };
                model.addRow(row); // Tambahkan data ke tabel
            }
        } catch (SQLException e) {
            // Tampilkan pesan error jika terjadi masalah
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Gagal memuat data: " + e.getMessage());
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtNominal = new javax.swing.JTextField();
        txtKategori = new javax.swing.JTextField();
        comboJenis = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1507, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 360));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(456, 330));

        jTable1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Jenis", "Kategori", "Nominal", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(500, 50));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 540, 320));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btnSimpan.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel5.add(btnSimpan);

        btnUbah.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel5.add(btnUbah);

        btnHapus.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel5.add(btnHapus);

        btnBatal.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel5.add(btnBatal);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 540, 50));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setPreferredSize(new java.awt.Dimension(490, 450));

        jLabel2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel2.setText("Kategori");

        jLabel3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel3.setText("Nominal");

        jLabel4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Transaksi");

        jLabel5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel5.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel6.setText("Total Pemasukan");

        jLabel7.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel7.setText("Total Pengeluaran");

        jLabel8.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel8.setText("Saldo Saat Ini :");

        jLabel9.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel9.setText("Tanggal");

        jDateChooser1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        txtNominal.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtNominal.setPreferredSize(new java.awt.Dimension(100, 28));

        txtKategori.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtKategori.setPreferredSize(new java.awt.Dimension(150, 28));
        txtKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKategoriActionPerformed(evt);
            }
        });

        comboJenis.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemasukan", "Pengeluaran" }));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 50));

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtKeterangan.setRows(5);
        jScrollPane2.setViewportView(txtKeterangan);

        btnTambah.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setPreferredSize(new java.awt.Dimension(85, 35));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(txtKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtKategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 560, 430));

        btnKeluar.setBackground(new java.awt.Color(255, 0, 51));
        btnKeluar.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.setPreferredSize(new java.awt.Dimension(95, 35));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 400, -1, -1));

        jButton1.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jButton1.setText("Import");
        jButton1.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        jButton2.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jButton2.setText("Export");
        jButton2.setPreferredSize(new java.awt.Dimension(95, 35));
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel1.setText("Aplikasi Keuangan Pribadi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(jLabel1)
                .addContainerGap(784, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKategoriActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          TransaksiHandler handler = new TransaksiHandler();
          handler.loadTable(jTable1);
    }//GEN-LAST:event_formWindowActivated

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
         try {
        Connection conn = Koneksi.getConnection();
        String sql = "INSERT INTO transaksi (tanggal, jenis, kategori, nominal, keterangan) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        // Set nilai dari input pengguna
        ps.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime())); // Ambil tanggal dari JDateChooser
        ps.setString(2, comboJenis.getSelectedItem().toString());           // Ambil jenis dari JComboBox
        ps.setString(3, txtKategori.getText());                             // Ambil kategori dari JTextField
        ps.setDouble(4, Double.parseDouble(txtNominal.getText()));          // Ambil nominal dari JTextField
        ps.setString(5, txtKeterangan.getText());                           // Ambil keterangan dari JTextArea

        ps.executeUpdate(); // Eksekusi query untuk menambah data

        // Reset inputan
        txtKategori.setText("");
        txtNominal.setText("");
        txtKeterangan.setText("");
        jDateChooser1.setDate(null);
        comboJenis.setSelectedIndex(0);

        // Tampilkan pesan sukses
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");

        // Muat ulang tabel
        TransaksiHandler handler = new TransaksiHandler();
        handler.loadTable(jTable1); // jTable1 adalah nama JTable Anda
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        // Ambil model JTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Pindahkan data dari tabel ke inputan
        try {
            // Kolom ke-0: Tanggal
            java.util.Date tanggal = (java.util.Date) model.getValueAt(selectedRow, 0);
            jDateChooser1.setDate(tanggal); // Set ke JDateChooser
            
            // Kolom ke-1: Jenis Transaksi
            String jenis = model.getValueAt(selectedRow, 1).toString();
            comboJenis.setSelectedItem(jenis); // Set ke JComboBox
            
            // Kolom ke-2: Kategori
            String kategori = model.getValueAt(selectedRow, 2).toString();
            txtKategori.setText(kategori); // Set ke JTextField
            
            // Kolom ke-3: Nominal
            String nominal = model.getValueAt(selectedRow, 3).toString();
            txtNominal.setText(nominal); // Set ke JTextField
            
            // Kolom ke-4: Keterangan
            String keterangan = model.getValueAt(selectedRow, 4).toString();
            txtKeterangan.setText(keterangan); // Set ke JTextArea

            // Set tombol yang sesuai
            btnTambah.setEnabled(false); // Disable tombol Tambah
            btnSimpan.setEnabled(true); // Enable tombol Simpan
            btnHapus.setEnabled(true); // Enable tombol Hapus
            btnBatal.setEnabled(true); // Enable tombol Batal
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeuanganPribadiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables
}
