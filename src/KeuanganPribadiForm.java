import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class KeuanganPribadiForm extends javax.swing.JFrame {
     // Variabel untuk menyimpan ID baris yang dipilih
    private int selectedId = -1;

    // List untuk menyimpan ID dari data di tabel
    private List<Integer> listId = new ArrayList<>();
    public KeuanganPribadiForm() {
        initComponents();   
    }
  
    //method agar inputan tidak boleh kosong
    private boolean validateInputs() {
    if (txtNominal.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nominal harus diisi!");
        return false;
    }
    if (txtKategori.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Kategori harus diisi!");
        return false;
    }
    if (comboJenis.getSelectedItem() == null || comboJenis.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Jenis transaksi harus dipilih!");
        return false;
    }
    if (txtKeterangan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Keterangan harus diisi!");
        return false;
    }
    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Tanggal harus diisi!");
        return false;
    }
    // Jika semua validasi lolos
    return true;
}
 
    // Metode untuk mengatur input bisa di-edit atau tidak
private void setEditableInput(boolean editable) {
    txtKategori.setEditable(editable);
    txtNominal.setEditable(editable);
    txtKeterangan.setEditable(editable);
    jDateChooser1.setEnabled(editable);
    comboJenis.setEnabled(editable);
}

// Reset input form
private void resetInput() {
    txtKategori.setText("");
    txtNominal.setText("");
    txtKeterangan.setText("");
    jDateChooser1.setDate(null);
    comboJenis.setSelectedIndex(0);
    btnTambah.setEnabled(true);
    btnSimpan.setEnabled(false);
    btnHapus.setEnabled(false);
    btnUbah.setEnabled(false);
    btnBatal.setEnabled(false);
    selectedId = -1; // Reset ID
}
 // Load data dari database ke JTable
private void loadTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Hapus semua baris di tabel
    listId.clear(); // Kosongkan daftar ID

    try {
        Connection conn = Koneksi.getConnection();
        String sql = "SELECT * FROM transaksi";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // Tambahkan data ke tabel (kecuali ID)
            Object[] row = {
                rs.getDate("tanggal"),      // Tanggal
                rs.getString("jenis"),     // Jenis transaksi
                rs.getString("kategori"),  // Kategori
                rs.getDouble("nominal"),   // Nominal
                rs.getString("keterangan") // Keterangan
            };
            model.addRow(row);

            // Simpan ID ke list
            listId.add(rs.getInt("id_transaksi"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
    }
}
//method untuk mengubah format nominal ke rupiah
private String formatRupiah(double value) {
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    return formatRupiah.format(value);
}

//method untuk menampilkan total pengeluaran, total pemasukan dan saldo
private void calculateTotals() {
    double totalPemasukan = 0;
    double totalPengeluaran = 0;

    try {
        Connection conn = Koneksi.getConnection();
        String sqlPemasukan = "SELECT SUM(nominal) AS total FROM transaksi WHERE jenis = 'Pemasukan'";
        String sqlPengeluaran = "SELECT SUM(nominal) AS total FROM transaksi WHERE jenis = 'Pengeluaran'";

        // menghitung total pemasukan
        PreparedStatement psPemasukan = conn.prepareStatement(sqlPemasukan);
        ResultSet rsPemasukan = psPemasukan.executeQuery();
        if (rsPemasukan.next()) {
            totalPemasukan = rsPemasukan.getDouble("total");
        }

        // menghitung total pengeluaran
        PreparedStatement psPengeluaran = conn.prepareStatement(sqlPengeluaran);
        ResultSet rsPengeluaran = psPengeluaran.executeQuery();
        if (rsPengeluaran.next()) {
            totalPengeluaran = rsPengeluaran.getDouble("total");
        }

        // menghitung saldo saat ini
        double saldoSaatIni = totalPemasukan - totalPengeluaran;

        // Tampilkan hasil pada label
        lblPemasukan.setText(formatRupiah(totalPemasukan));
        lblPengeluaran.setText(formatRupiah(totalPengeluaran));
        lblSaldo.setText(formatRupiah(saldoSaatIni));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menghitung total: " + e.getMessage());
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
        lblPemasukan = new javax.swing.JLabel();
        lblPengeluaran = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(116, 194, 185));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Haikal Aditya Rahmatullah"));
        jPanel1.setPreferredSize(new java.awt.Dimension(1507, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(116, 194, 185));
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(500, 300));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setMinWidth(90);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(2).setMinWidth(110);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 540, 320));

        jPanel5.setBackground(new java.awt.Color(116, 194, 185));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btnSimpan.setBackground(new java.awt.Color(0, 153, 51));
        btnSimpan.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setPreferredSize(new java.awt.Dimension(95, 35));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel5.add(btnSimpan);

        btnUbah.setBackground(new java.awt.Color(0, 153, 51));
        btnUbah.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah");
        btnUbah.setPreferredSize(new java.awt.Dimension(95, 35));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel5.add(btnUbah);

        btnHapus.setBackground(new java.awt.Color(0, 153, 51));
        btnHapus.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(95, 35));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel5.add(btnHapus);

        btnBatal.setBackground(new java.awt.Color(0, 153, 51));
        btnBatal.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(95, 35));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel5.add(btnBatal);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 540, 50));

        jPanel4.setBackground(new java.awt.Color(116, 194, 185));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "    "));
        jPanel4.setPreferredSize(new java.awt.Dimension(490, 450));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel2.setText("Kategori");

        jLabel3.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel3.setText("Nominal");

        jLabel4.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Transaksi");

        jLabel5.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel5.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel6.setText("Total Pemasukan    :");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel7.setText("Total Pengeluaran  :");

        jLabel8.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel8.setText("Saldo Saat Ini            :");

        jLabel9.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel9.setText("Tanggal");

        jDateChooser1.setDateFormatString("dd, MMMM, yyyy");
        jDateChooser1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        txtNominal.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtNominal.setPreferredSize(new java.awt.Dimension(100, 28));
        txtNominal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNominalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNominalKeyTyped(evt);
            }
        });

        txtKategori.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtKategori.setPreferredSize(new java.awt.Dimension(150, 28));
        txtKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKategoriActionPerformed(evt);
            }
        });

        comboJenis.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih - ", "Pemasukan", "Pengeluaran" }));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 50));

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtKeterangan.setRows(5);
        jScrollPane2.setViewportView(txtKeterangan);

        btnTambah.setBackground(new java.awt.Color(51, 153, 255));
        btnTambah.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setPreferredSize(new java.awt.Dimension(85, 35));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        lblPemasukan.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N

        lblPengeluaran.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N

        lblSaldo.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N

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
                        .addComponent(txtKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSaldo)
                                    .addComponent(lblPengeluaran)
                                    .addComponent(lblPemasukan))))
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
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblPemasukan))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblPengeluaran))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblSaldo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 560, 450));

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
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, -1, -1));

        btnImport.setBackground(new java.awt.Color(255, 153, 102));
        btnImport.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setText("Import");
        btnImport.setPreferredSize(new java.awt.Dimension(95, 35));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jPanel1.add(btnImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, -1, -1));

        btnExport.setBackground(new java.awt.Color(255, 153, 102));
        btnExport.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setText("Export");
        btnExport.setPreferredSize(new java.awt.Dimension(95, 35));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel1.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel1.setText("Aplikasi Keuangan Pribadi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1174, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKategoriActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        loadTable();
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
        btnUbah.setEnabled(false);
        btnBatal.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (!validateInputs()) {
        return; // Hentikan proses jika validasi gagal
    }
        try {
        Connection conn = Koneksi.getConnection();
        String sql = "INSERT INTO transaksi (tanggal, jenis, kategori, nominal, keterangan) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime())); // Ambil tanggal
        ps.setString(2, comboJenis.getSelectedItem().toString());           // Ambil jenis
        ps.setString(3, txtKategori.getText());                             // Ambil kategori
        ps.setDouble(4, Double.parseDouble(txtNominal.getText()));          // Ambil nominal
        ps.setString(5, txtKeterangan.getText());                           // Ambil keterangan
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
        resetInput();
        calculateTotals();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        selectedId = listId.get(selectedRow); // Ambil ID dari listId

        try {
            java.util.Date tanggal = (java.util.Date) model.getValueAt(selectedRow, 0);
            jDateChooser1.setDate(tanggal);
            String jenis = model.getValueAt(selectedRow, 1).toString();
            comboJenis.setSelectedItem(jenis);
            String kategori = model.getValueAt(selectedRow, 2).toString();
            txtKategori.setText(kategori);
            String nominal = model.getValueAt(selectedRow, 3).toString();
            txtNominal.setText(nominal);
            String keterangan = model.getValueAt(selectedRow, 4).toString();
            txtKeterangan.setText(keterangan);

            setEditableInput(false);
            btnTambah.setEnabled(false);
            btnSimpan.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
            btnBatal.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (selectedId != -1) {
        setEditableInput(true);
        btnSimpan.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    } else {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah!");
    }    
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!validateInputs()) {
        return; // Hentikan proses jika validasi gagal
    }
        try {
        Connection conn = Koneksi.getConnection();
        String sql = "UPDATE transaksi SET tanggal = ?, jenis = ?, kategori = ?, nominal = ?, keterangan = ? WHERE id_transaksi = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
        ps.setString(2, comboJenis.getSelectedItem().toString());
        ps.setString(3, txtKategori.getText());
        ps.setDouble(4, Double.parseDouble(txtNominal.getText()));
        ps.setString(5, txtKeterangan.getText());
        ps.setInt(6, selectedId);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
        resetInput();
        calculateTotals();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
if (selectedId != -1) {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection conn = Koneksi.getConnection();
                String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, selectedId);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                resetInput();
                setEditableInput(true);
                calculateTotals();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        resetInput();
        setEditableInput(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
        // Pilih lokasi dan nama file
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Pilih lokasi untuk menyimpan file CSV");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".csv")) {
                filePath += ".csv"; // Tambahkan ekstensi .csv jika belum ada
            }

            // Tulis data ke file CSV
            try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
                Connection conn = Koneksi.getConnection();
                String sql = "SELECT * FROM transaksi";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                // Tulis header
                writer.append("ID,Tanggal,Jenis,Kategori,Nominal,Keterangan\n");

                // Tulis data
                while (rs.next()) {
                    writer.append(rs.getInt("id_transaksi") + ",")
                          .append(rs.getDate("tanggal") + ",")
                          .append(rs.getString("jenis") + ",")
                          .append(rs.getString("kategori") + ",")
                          .append(rs.getDouble("nominal") + ",")
                          .append(rs.getString("keterangan") + "\n");
                }

                JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke " + filePath);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengekspor data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        try {
        // Pilih file CSV
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Pilih file CSV untuk diimpor");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Baca data dari file CSV
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
                String line;
                Connection conn = Koneksi.getConnection();
                String sql = "INSERT INTO transaksi (tanggal, jenis, kategori, nominal, keterangan) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                // Lewati baris header
                line = reader.readLine();

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    java.sql.Date tanggal = java.sql.Date.valueOf(data[1].trim());
                    String jenis = data[2].trim();
                    String kategori = data[3].trim();
                    double nominal = Double.parseDouble(data[4].trim());
                    String keterangan = data[5].trim();

                    // Masukkan ke database
                    ps.setDate(1, tanggal);
                    ps.setString(2, jenis);
                    ps.setString(3, kategori);
                    ps.setDouble(4, nominal);
                    ps.setString(5, keterangan);
                    ps.addBatch();
                }

                // Eksekusi batch
                ps.executeBatch();
                JOptionPane.showMessageDialog(this, "Data berhasil diimpor dari " + filePath);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengimpor data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnImportActionPerformed

    private void txtNominalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNominalKeyReleased
 
    }//GEN-LAST:event_txtNominalKeyReleased

    private void txtNominalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNominalKeyTyped
        char c = evt.getKeyChar();
    if (!Character.isDigit(c) && c != '.') {
        evt.consume();  // Hanya menerima angka dan titik desimal
    }
    }//GEN-LAST:event_txtNominalKeyTyped

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
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboJenis;
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
    private javax.swing.JLabel lblPemasukan;
    private javax.swing.JLabel lblPengeluaran;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables
}
