/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author thegr
 */
public class Menu extends javax.swing.JFrame {
    Connection con = null;
    /**
     * Creates new form Menu
     */
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public Menu() {
        initComponents();
        mostrarIng();
        mostrarDep();
        mostrarPro();
        comboIng();
        comboDep();
        comboDepPro();
        comboIngPro();
        comboProyectos();
    }
    public void comboIng(){
        /*ComboBox Ingenieros*/
        String comboIng="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT especialidad FROM ingeniero")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboIng= rs.getString("especialidad");
                comboBoxIng.addItem(comboIng);
            }
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    public void comboDep(){
        /*ComboBox Departamentos*/
        String comboDep="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT nombre FROM departamentos")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboDep= rs.getString("nombre");
                comboBoxDep.addItem(comboDep);
            }
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la carga de datos:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    public void comboPro(){
        /*ComboBox Ingenieros*/
        String comboPro="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT especialidad FROM ingeniero")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboPro= rs.getString("especialidad");
                comboBoxIng.addItem(comboPro);
            }
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    
    public void comboIngPro(){
        /*ComboBox lista de Ingenieros - Proyectos*/
        String comboPro="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT especialidad FROM ingeniero")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboPro= rs.getString("especialidad");
                comboBoxIngPro.addItem(comboPro);
            }
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    
    public void comboDepPro(){
        /*ComboBox lista de Departamentos - Proyectos*/
        String comboDep="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT nombre FROM departamentos")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboDep= rs.getString("nombre");
                comboBoxDepPro.addItem(comboDep);
            }
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la carga de datos:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    
    public void comboProyectos(){
        /*ComboBox lista de Proyectos*/
        String comboPro="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT nombre FROM proyectos")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next()){
                comboPro= rs.getString("nombre");
                comboBoxProyectos.addItem(comboPro);
            } 
        } catch (SQLException sqle) {
            System.out.println("Error en la carga de datos:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }
    
    public void mostrarPro() {
        /*Pestaña Proyecto*/
        String areaPro="";
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT * FROM proyectos")) {
            ResultSet rs = stmt3.executeQuery();
            while (rs.next())
                areaPro= areaPro + rs.getString("idproy")+"\t"+rs.getString("nombre")+"\t"+rs.getString("fec_inicio")+"\t"+rs.getString("fec_termino")+"\t"+rs.getString("id_depto")+"\t"+rs.getString("id_ing") + "\n";
            txtAreaPro.setText(areaPro);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }

    public void mostrarDep() {
        /*Pestaña Departamento*/
        String areaDep="";
        try (PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM departamentos")) {
            ResultSet rs = stmt2.executeQuery();
            while (rs.next())
                areaDep= areaDep + rs.getString("iddpto")+"\t"+rs.getString("nombre")+"\t"+rs.getString("telefono")+"\t"+rs.getString("fax") + "\n";
            txtAreaDep.setText(areaDep);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }

    public void mostrarIng() {
        conexion();
        /*Pestaña Ingenieros*/
        String areaing="";
        try (PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM ingeniero")) {
            ResultSet rs = stmt1.executeQuery();
            while (rs.next())
                areaing= areaing + rs.getString("iding")+"\t"+rs.getString("especialidad")+"\t"+rs.getString("cargo") + "\n";
            txtAreaIng.setText(areaing);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));
            
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }
    
    private void conexion(){
        
        String sURL = "jdbc:mysql://localhost:3306/proyectostest";
        try {
            con = DriverManager.getConnection(sURL,"root","");
            System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            Logger.getLogger(PruebaFinal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pestanias = new javax.swing.JTabbedPane();
        pestaniaIng = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodIng = new javax.swing.JTextField();
        txtEspIng = new javax.swing.JTextField();
        txtCarIng = new javax.swing.JTextField();
        btn_Ins_Ing = new javax.swing.JButton();
        btn_Act_Ing = new javax.swing.JButton();
        btn_Eli_Ing = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaIng = new javax.swing.JTextArea();
        comboBoxIng = new javax.swing.JComboBox<>();
        pestaniaProy = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        txtNomPro = new javax.swing.JTextField();
        txtIniPro = new javax.swing.JTextField();
        txtFinPro = new javax.swing.JTextField();
        btn_Ins_Pro = new javax.swing.JButton();
        btn_Act_Pro = new javax.swing.JButton();
        btn_Eli_Pro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaPro = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxIngPro = new javax.swing.JComboBox<>();
        comboBoxDepPro = new javax.swing.JComboBox<>();
        comboBoxProyectos = new javax.swing.JComboBox<>();
        pestaniaDep = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodDep = new javax.swing.JTextField();
        txtNomDep = new javax.swing.JTextField();
        txtTelDep = new javax.swing.JTextField();
        txtFaxDep = new javax.swing.JTextField();
        btn_Ins_Dep = new javax.swing.JButton();
        btn_Act_Dep = new javax.swing.JButton();
        btn_Eli_Dep = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaDep = new javax.swing.JTextArea();
        comboBoxDep = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("SISTEMA DE GESTION DE PROYECTOS");

        jLabel2.setText("Codigo: ");

        jLabel3.setText("Especialidad: ");

        jLabel4.setText("Cargo: ");

        txtCodIng.setEnabled(false);
        txtCodIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodIngActionPerformed(evt);
            }
        });

        txtCarIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarIngActionPerformed(evt);
            }
        });

        btn_Ins_Ing.setText("Insertar");
        btn_Ins_Ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ins_IngActionPerformed(evt);
            }
        });

        btn_Act_Ing.setText("Actualizar");

        btn_Eli_Ing.setText("Eliminar");
        btn_Eli_Ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eli_IngActionPerformed(evt);
            }
        });

        txtAreaIng.setColumns(20);
        txtAreaIng.setRows(5);
        jScrollPane1.setViewportView(txtAreaIng);

        comboBoxIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIngActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestaniaIngLayout = new javax.swing.GroupLayout(pestaniaIng);
        pestaniaIng.setLayout(pestaniaIngLayout);
        pestaniaIngLayout.setHorizontalGroup(
            pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaniaIngLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaIngLayout.createSequentialGroup()
                        .addGap(0, 168, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(pestaniaIngLayout.createSequentialGroup()
                        .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEspIng, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(txtCarIng)
                            .addComponent(txtCodIng, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pestaniaIngLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_Ins_Ing)
                                .addGap(62, 62, 62)
                                .addComponent(btn_Act_Ing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Eli_Ing)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaIngLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxIng, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        pestaniaIngLayout.setVerticalGroup(
            pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaniaIngLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEspIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ins_Ing)
                    .addComponent(btn_Act_Ing)
                    .addComponent(btn_Eli_Ing))
                .addGap(18, 18, 18)
                .addGroup(pestaniaIngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCarIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pestanias.addTab("Ingenieros", pestaniaIng);

        jLabel9.setText("Codigo: ");

        jLabel10.setText("Nombre: ");

        jLabel11.setText("Inicio(AAAA-MM-DD): ");

        jLabel12.setText("Termino(AAAA-MM-DD): ");

        txtCodPro.setEnabled(false);

        btn_Ins_Pro.setText("Insertar");
        btn_Ins_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ins_ProActionPerformed(evt);
            }
        });

        btn_Act_Pro.setText("Actualizar");

        btn_Eli_Pro.setText("Eliminar");
        btn_Eli_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eli_ProActionPerformed(evt);
            }
        });

        txtAreaPro.setColumns(20);
        txtAreaPro.setRows(5);
        jScrollPane2.setViewportView(txtAreaPro);

        jLabel13.setText("Cod. Ingeniero: ");

        jLabel14.setText("Cod. Departamento: ");

        javax.swing.GroupLayout pestaniaProyLayout = new javax.swing.GroupLayout(pestaniaProy);
        pestaniaProy.setLayout(pestaniaProyLayout);
        pestaniaProyLayout.setHorizontalGroup(
            pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaProyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                        .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pestaniaProyLayout.createSequentialGroup()
                                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaProyLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)))
                                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxDepPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                                        .addComponent(btn_Ins_Pro)
                                        .addGap(71, 71, 71)
                                        .addComponent(btn_Act_Pro))
                                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(59, 59, 59)
                                        .addComponent(comboBoxIngPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(comboBoxProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pestaniaProyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFinPro, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txtIniPro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Eli_Pro))))
                    .addComponent(jScrollPane2))
                .addGap(24, 24, 24))
        );
        pestaniaProyLayout.setVerticalGroup(
            pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaniaProyLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboBoxIngPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(comboBoxDepPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestaniaProyLayout.createSequentialGroup()
                        .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtIniPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaProyLayout.createSequentialGroup()
                        .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Ins_Pro)
                            .addComponent(btn_Act_Pro)
                            .addComponent(btn_Eli_Pro))
                        .addGap(1, 1, 1)))
                .addGroup(pestaniaProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtFinPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pestanias.addTab("Proyectos", pestaniaProy);

        jLabel5.setText("Codigo: ");

        jLabel6.setText("Nombre: ");

        jLabel7.setText("Telefono: ");

        jLabel8.setText("Fax: ");

        txtCodDep.setEnabled(false);

        btn_Ins_Dep.setText("Insertar");
        btn_Ins_Dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ins_DepActionPerformed(evt);
            }
        });

        btn_Act_Dep.setText("Actualizar");

        btn_Eli_Dep.setText("Eliminar");

        txtAreaDep.setColumns(20);
        txtAreaDep.setRows(5);
        jScrollPane3.setViewportView(txtAreaDep);

        javax.swing.GroupLayout pestaniaDepLayout = new javax.swing.GroupLayout(pestaniaDep);
        pestaniaDep.setLayout(pestaniaDepLayout);
        pestaniaDepLayout.setHorizontalGroup(
            pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaniaDepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestaniaDepLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(46, 46, 46))
                    .addGroup(pestaniaDepLayout.createSequentialGroup()
                        .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomDep)
                            .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelDep)
                            .addComponent(txtFaxDep, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pestaniaDepLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btn_Ins_Dep)
                                .addGap(71, 71, 71)
                                .addComponent(btn_Act_Dep)
                                .addGap(83, 83, 83)
                                .addComponent(btn_Eli_Dep)
                                .addGap(0, 99, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaniaDepLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxDep, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))))
        );
        pestaniaDepLayout.setVerticalGroup(
            pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaniaDepLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pestaniaDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFaxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ins_Dep)
                    .addComponent(btn_Act_Dep)
                    .addComponent(btn_Eli_Dep))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pestanias.addTab("Departamentos", pestaniaDep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pestanias)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pestanias)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodIngActionPerformed

    private void txtCarIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarIngActionPerformed

    private void btn_Ins_IngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ins_IngActionPerformed
        // TODO add your handling code here:
        String codigoIng = txtCodIng.getText();
        String especialidadIng = txtEspIng.getText();
        String cargoIng = txtCarIng.getText();
        
        String areaing="";
        try (PreparedStatement stmt4 = con.prepareStatement(" insert into ingeniero (especialidad, cargo)" + " values ('"+especialidadIng+"', '"+cargoIng+"')")) {
            stmt4.execute();
            mostrarIng();
            //ResultSet rs = stmt1.executeQuery();
            //areaing= areaing + rs.getString("iding")+"\t"+rs.getString("especialidad")+"\t"+rs.getString("cargo") + "\n";
            //txtAreaIng.setText(areaing);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));

        } catch (SQLException sqle) { 
            System.out.println("Error en la ejecución:" 
              + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }//GEN-LAST:event_btn_Ins_IngActionPerformed

    private void btn_Ins_DepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ins_DepActionPerformed
        // TODO add your handling code here:
        String codigoDep = txtCodDep.getText();
        String nombreDep = txtNomDep.getText();
        String telefonoDep = txtTelDep.getText();
        String faxDep = txtFaxDep.getText();
        String areaDep="";
        try (PreparedStatement stmt4 = con.prepareStatement(" insert into departamentos (nombre, telefono, fax)" + " values ('"+nombreDep+"', '"+telefonoDep+"','"+faxDep+"')")) {
            stmt4.execute();
            mostrarDep();
            
            //ResultSet rs = stmt1.executeQuery();
            //areaing= areaing + rs.getString("iding")+"\t"+rs.getString("especialidad")+"\t"+rs.getString("cargo") + "\n";
            //txtAreaIng.setText(areaing);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));

        } catch (SQLException sqle) { 
            System.out.println("Error en la ejecución:" 
              + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }//GEN-LAST:event_btn_Ins_DepActionPerformed

    private void comboBoxIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxIngActionPerformed

    private void btn_Eli_IngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eli_IngActionPerformed
        // TODO add your handling code here:
        int eliminar = comboBoxIng.getSelectedIndex();
        String consulta = "delete from ingeniero where iding = '"+eliminar+"'";
        try (PreparedStatement stmt4 = con.prepareStatement(consulta)) {
            stmt4.execute();
            mostrarIng();

        } catch (SQLException sqle) { 
            System.out.println("Error en la ejecución:" 
              + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
    }//GEN-LAST:event_btn_Eli_IngActionPerformed

    private void btn_Eli_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eli_ProActionPerformed
        // TODO add your handling code here:
        int eliminar = comboBoxProyectos.getSelectedIndex()+1;
        System.out.println(eliminar);
        /*String consulta = "delete from proyectos where idproy = '"+eliminar+"'";
        try (PreparedStatement stmt4 = con.prepareStatement(consulta)) {
            stmt4.execute();
            mostrarPro();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                + sqle.getErrorCode() + " " + sqle.getMessage());
        }*/
    }//GEN-LAST:event_btn_Eli_ProActionPerformed

    private void btn_Ins_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ins_ProActionPerformed
        // TODO add your handling code here:
        String codigoPro = txtCodPro.getText();
        String nombrePro = txtNomPro.getText();
        String iniPro = txtIniPro.getText();
        String finPro = txtFinPro.getText();
        int codigoInge = comboBoxIngPro.getSelectedIndex();
        String codigoInge2 = Integer.toString(codigoInge);
        int codigoDepa = comboBoxDepPro.getSelectedIndex();
        String codigoDepa2 = Integer.toString(codigoDepa);
        //String codigoInge = txtCodInge.getText();
        //String codigoDepa = txtCodDepa.getText();
        //Date fec_inicios = ParseFecha(iniPro);
        //Date fec_terminos = ParseFecha(finPro);
        //System.out.print(fec_terminos.toString());
        String areaPro="";
        try (PreparedStatement stmt4 = con.prepareStatement(" insert into proyectos (nombre, fec_inicio, fec_termino, id_depto, id_ing)" + " values ('"+nombrePro+"','"+iniPro+"','"+finPro+"','"+codigoDepa2+"','"+codigoInge2+"')")) {
            stmt4.execute();
            mostrarPro();

            //ResultSet rs = stmt1.executeQuery();
            //areaing= areaing + rs.getString("iding")+"\t"+rs.getString("especialidad")+"\t"+rs.getString("cargo") + "\n";
            //txtAreaIng.setText(areaing);
            //System.out.println(rs.getString("nombre")+"|\t"+rs.getString("telefono")+"|\t"+rs.getString("fax"));

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }//GEN-LAST:event_btn_Ins_ProActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Act_Dep;
    private javax.swing.JButton btn_Act_Ing;
    private javax.swing.JButton btn_Act_Pro;
    private javax.swing.JButton btn_Eli_Dep;
    private javax.swing.JButton btn_Eli_Ing;
    private javax.swing.JButton btn_Eli_Pro;
    private javax.swing.JButton btn_Ins_Dep;
    private javax.swing.JButton btn_Ins_Ing;
    private javax.swing.JButton btn_Ins_Pro;
    private javax.swing.JComboBox<String> comboBoxDep;
    private javax.swing.JComboBox<String> comboBoxDepPro;
    private javax.swing.JComboBox<String> comboBoxIng;
    private javax.swing.JComboBox<String> comboBoxIngPro;
    private javax.swing.JComboBox<String> comboBoxProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pestaniaDep;
    private javax.swing.JPanel pestaniaIng;
    private javax.swing.JPanel pestaniaProy;
    private javax.swing.JTabbedPane pestanias;
    private javax.swing.JTextArea txtAreaDep;
    private javax.swing.JTextArea txtAreaIng;
    private javax.swing.JTextArea txtAreaPro;
    private javax.swing.JTextField txtCarIng;
    private javax.swing.JTextField txtCodDep;
    private javax.swing.JTextField txtCodIng;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtEspIng;
    private javax.swing.JTextField txtFaxDep;
    private javax.swing.JTextField txtFinPro;
    private javax.swing.JTextField txtIniPro;
    private javax.swing.JTextField txtNomDep;
    private javax.swing.JTextField txtNomPro;
    private javax.swing.JTextField txtTelDep;
    // End of variables declaration//GEN-END:variables
}
