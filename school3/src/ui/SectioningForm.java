/*
 * SectioningForm.java
 *
 * Created on April 29, 2009, 1:42 PM
 */

package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ToolTipManager;

import service.util.WSPersistenceEntityManager;
import springbean.AAAConfig;
import template.report.AbstractReportTemplate;
import template.screen.TransactionPanel;
import util.BeanUtil;
import util.DBClient;
import util.PanelUtil;
import bean.Student;
import bean.person.StudentValuesGrading;

/**
 *
 * @author  Administrator
 */
public class SectioningForm extends TransactionPanel {

    @Override
	public String getTitle() {
		return "Organization List";
	}

	/** Creates new form SectioningForm */
    public SectioningForm() {
        initComponents();
        javax.swing.JButton btnShowPromotionReport = new javax.swing.JButton();
        btnShowPromotionReport.setText("Show Promotion Report");
        btnShowPromotionReport.setName("btnShowSectioningReport"); // NOI18N
        btnShowPromotionReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPromotionReportActionPerformed(evt);
            }
        });
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 0);
        jPanel5.add(btnShowPromotionReport, gridBagConstraints);
//        btnShowPromotionReport.setVisible(AppConfig.hasPromotionReport());
        btnRefreshListActionPerformed(null);
    }

     protected void btnShowPromotionReportActionPerformed(ActionEvent evt) {
    	 bean.reference.Section sec = (bean.reference.Section) cboSection.getSelectedItem();
    	 AbstractReportTemplate.getInstance().showReportFromFileTemplate(BeanUtil.concat("Promotion",sec.gradeLevel), "");
	}

	public static void main(String[] args) {
        java.awt.Color clr = new java.awt.Color(44, 117, 44);
        constants.Constants.panelBackground = clr;
        constants.Constants.labelColor = Color.WHITE;
        AAAConfig.getInstance();

        PanelUtil.displayToFrame(new SectioningForm());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        schoolPUEntityManager = WSPersistenceEntityManager.getInstance();
        personQuery = schoolPUEntityManager.createQuery("SELECT p FROM Student p WHERE p.personId=0"); // NOI18N
        lstStudentWithoutSection = org.jdesktop.observablecollections.ObservableCollections.observableList(personQuery.getResultList());
        personQuery1 = schoolPUEntityManager.createQuery("SELECT p FROM Student p WHERE p.personId=0"); // NOI18N
        lstStudentWithSection = org.jdesktop.observablecollections.ObservableCollections.observableList(personQuery1.getResultList());
        sectionQuery = schoolPUEntityManager.createQuery("SELECT s FROM Section s ORDER BY s.gradeLevel, s.code"); // NOI18N
        sectionList = sectionQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        lblSection = new javax.swing.JLabel();
        cboSection = new component.JComboBoxPallete();
        jPanel5 = new javax.swing.JPanel();
        lblBoys = new javax.swing.JLabel();
        lblGirls = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtBoys = new component.JTextFieldPallete();
        txtGirls = new component.JTextFieldPallete();
        txtTotal = new component.JTextFieldPallete();
        btnShowSectioningReport = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnrolledStudent = getNewTable();
        jPanel7 = new javax.swing.JPanel();
        cboGradeFilter = new javax.swing.JComboBox();
        btnRefreshList = new javax.swing.JButton();
        btnPutToSection = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnrolledStudentSection = getNewTable();
        jPanel6 = new javax.swing.JPanel();
        btnRemoveFromSection = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblSection.setText("Step 1: Select Section");
        lblSection.setName("lblSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(lblSection, gridBagConstraints);

        cboSection.setName("cboSection"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sectionList, cboSection);
        bindingGroup.addBinding(jComboBoxBinding);

        cboSection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSectionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(cboSection, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Number of Students in Section"));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        lblBoys.setText("Boys:");
        lblBoys.setName("lblBoys"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel5.add(lblBoys, gridBagConstraints);

        lblGirls.setText("Girls:");
        lblGirls.setName("lblGirls"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel5.add(lblGirls, gridBagConstraints);

        lblTotal.setText("Total:");
        lblTotal.setName("lblTotal"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel5.add(lblTotal, gridBagConstraints);

        txtBoys.setEditable(false);
        txtBoys.setName("txtBoys"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel5.add(txtBoys, gridBagConstraints);

        txtGirls.setEditable(false);
        txtGirls.setName("txtGirls"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel5.add(txtGirls, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.setName("txtTotal"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel5.add(txtTotal, gridBagConstraints);

        btnShowSectioningReport.setText("Show Organization Report");
        btnShowSectioningReport.setName("btnShowSectioningReport"); // NOI18N
        btnShowSectioningReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSectioningReportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 0);
        jPanel5.add(btnShowSectioningReport, gridBagConstraints);

        add(jPanel5, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setDividerLocation(350);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Students Without Section"));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout(0, 10));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblEnrolledStudent.setName("tblEnrolledStudent"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstStudentWithoutSection, tblEnrolledStudent);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gradeLevel}"));
        columnBinding.setColumnName("Grade Level");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentNumber}"));
        columnBinding.setColumnName("Student Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${middleInitial}"));
        columnBinding.setColumnName("Middle Initial");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblEnrolledStudent);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel7.setName("jPanel7"); // NOI18N

        cboGradeFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "N1", "N2", "K1", "K2", "P1", "P2", "G1", "G2", "G3", "G4", "G5", "G6", "H1", "H2", "H3", "H4", "ALL" }));
        cboGradeFilter.setName("cboGradeFilter"); // NOI18N
        cboGradeFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGradeFilterItemStateChanged(evt);
            }
        });
        jPanel7.add(cboGradeFilter);

        btnRefreshList.setText("Refresh All");
        btnRefreshList.setName("btnRefreshList"); // NOI18N
        btnRefreshList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshListActionPerformed(evt);
            }
        });
        jPanel7.add(btnRefreshList);

        btnPutToSection.setText("Add Selected Student To Section");
        btnPutToSection.setName("btnPutToSection"); // NOI18N
        btnPutToSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPutToSectionActionPerformed(evt);
            }
        });
        jPanel7.add(btnPutToSection);

        jPanel3.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Student In Selected Section"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout(0, 10));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblEnrolledStudentSection.setName("tblEnrolledStudentSection"); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstStudentWithSection, tblEnrolledStudentSection);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentNumber}"));
        columnBinding.setColumnName("Student Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${middleInitial}"));
        columnBinding.setColumnName("Middle Initial");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gradeLevel}"));
        columnBinding.setColumnName("Grade Level");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tblEnrolledStudentSection);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel6.setName("jPanel6"); // NOI18N

        btnRemoveFromSection.setText("Remove Selected Student From Section");
        btnRemoveFromSection.setName("btnRemoveFromSection"); // NOI18N
        btnRemoveFromSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromSectionActionPerformed(evt);
            }
        });
        jPanel6.add(btnRemoveFromSection);

        jPanel2.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setRightComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

private void btnPutToSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPutToSectionActionPerformed
    bean.reference.Section sec = (bean.reference.Section) cboSection.getSelectedItem();
    int rowCount = lstStudentWithoutSection.size();
    final List lst = new ArrayList();
    for (int i=rowCount-1; i>=0; i--) {
        Student p = lstStudentWithoutSection.get(i);
    	if (tblEnrolledStudent.isRowSelected(i)) {
            p.section = sec.code;
            p.gradeLevel = sec.gradeLevel;
            p.course = sec.getCourse();
            lst.add(p);
            lstStudentWithSection.add(p);
            lstStudentWithoutSection.remove(i);
            p.updateEnrollmentSection();
            updateValuesSection(p.seq, sec.gradeLevel, sec.code, sec.facultyId);
    	}
    }
    Thread t = new Thread(new Runnable() {
		public void run() {
		    DBClient.persistBean(lst);
		}
    });
    t.start();
}//GEN-LAST:event_btnPutToSectionActionPerformed

	public void updateValuesSection(int personId, String gradeLevel, String section, int facultyId) {
		StudentValuesGrading e = (StudentValuesGrading) DBClient.getFirstRecord("SELECT a FROM StudentValuesGrading a WHERE a.studentId="
				, personId , " AND a.gradeLevel='",gradeLevel,"'");
		if (e != null) {
			e.section = section;
                        e.facultyId = facultyId;
                        e.faculty = "";
			e.save();
		}
		else {
			e = new StudentValuesGrading();
                        e.facultyId = facultyId;
                        e.faculty = "";
			e.studentId = personId;
			e.gradeLevel = gradeLevel;
			e.section = section;
			e.save();
		}
	}


private void btnRemoveFromSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromSectionActionPerformed
    bean.reference.Section sec = (bean.reference.Section) cboSection.getSelectedItem();
    int rowCount = lstStudentWithSection.size();
    final List lst = new ArrayList();
    for (int i=rowCount-1; i>=0; i--) {
    	if (tblEnrolledStudentSection.isRowSelected(i)) {
            Student p = lstStudentWithSection.get(i);
            p.section = null;
            lst.add(p);
            lstStudentWithoutSection.add(p);
            lstStudentWithSection.remove(i);
    	}
    }
    Thread t = new Thread(new Runnable() {
		public void run() {
		    DBClient.persistBean(lst);
		}
    });
    t.start();
}//GEN-LAST:event_btnRemoveFromSectionActionPerformed

private void cboSectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSectionItemStateChanged
	updateList();
}//GEN-LAST:event_cboSectionItemStateChanged

private void btnShowSectioningReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSectioningReportActionPerformed
    AbstractReportTemplate.getInstance().showReportFromFileTemplate("OrganizationalListSection", "");
}//GEN-LAST:event_btnShowSectioningReportActionPerformed

private void btnRefreshListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshListActionPerformed
    String grd = cboGradeFilter.getSelectedItem().toString();
    if (grd.isEmpty()) {
        List lst2 = DBClient.getList("SELECT a FROM Student a WHERE a.status='ENROLLED' AND (a.section IS NULL OR a.section='') AND (a.gradeLevel IS NULL OR a.gradeLevel='') ORDER BY a.lastName, a.firstName, a.middleInitial", 0, 10000);
        PanelUtil.setListData(lstStudentWithoutSection, lst2);
    }
    else if ("ALL".equals(grd)) {
        List lst2 = DBClient.getList("SELECT a FROM Student a WHERE a.status='ENROLLED' AND (a.section IS NULL OR a.section='') ORDER BY a.lastName, a.firstName, a.middleInitial", 0, 10000);
        PanelUtil.setListData(lstStudentWithoutSection, lst2);
    }
    else {
        List lst2 = DBClient.getList(BeanUtil.concat("SELECT a FROM Student a WHERE a.status='ENROLLED' AND (a.section IS NULL OR a.section='') AND a.gradeLevel='",grd,"' ORDER BY a.lastName, a.firstName, a.middleInitial"), 0, 10000);
        PanelUtil.setListData(lstStudentWithoutSection, lst2);
    }
}//GEN-LAST:event_btnRefreshListActionPerformed

String oldGradeLevel = null;

private void cboGradeFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGradeFilterItemStateChanged
    String grd = cboGradeFilter.getSelectedItem().toString();
    if (grd==null) return;
    if (oldGradeLevel!=null && oldGradeLevel.equals(grd)) {
//    	this is same section
    	return;
    }
    oldGradeLevel = grd;
    btnRefreshListActionPerformed(null);
}//GEN-LAST:event_cboGradeFilterItemStateChanged
private String oldSection;
protected void updateList() {
    bean.reference.Section sec = (bean.reference.Section) cboSection.getSelectedItem();
    if (sec==null) return;
    if (oldSection!=null && oldSection.equals(sec.code)) {
//    	this is same section
    	return;
    }
    oldSection = sec.code;
    refreshSectionStudent();
}

protected void refreshSectionStudent() {
    bean.reference.Section sec = (bean.reference.Section) cboSection.getSelectedItem();
    if (sec==null) return;
    List<Student> lst = DBClient.getList(BeanUtil.concat("SELECT a FROM Student a WHERE a.status='ENROLLED' AND a.section='",sec.code,"' ORDER BY a.gradeLevel, a.lastName, a.middleInitial, a.firstName"),0,100);
    PanelUtil.setListData(lstStudentWithSection, lst);

    int boys = 0;
    int girls = 0;
    for (Student s : lst) {
        if (s.gender.startsWith("M")) {
            boys++;
        }
        else {
            girls++;
        }
    }
    txtBoys.setText(BeanUtil.concat(boys));
    txtGirls.setText(BeanUtil.concat(girls));
    txtTotal.setText(BeanUtil.concat((boys+girls)));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPutToSection;
    private javax.swing.JButton btnRefreshList;
    private javax.swing.JButton btnRemoveFromSection;
    private javax.swing.JButton btnShowSectioningReport;
    private javax.swing.JComboBox cboGradeFilter;
    private component.JComboBoxPallete cboSection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblBoys;
    private javax.swing.JLabel lblGirls;
    private javax.swing.JLabel lblSection;
    private javax.swing.JLabel lblTotal;
    private java.util.List<bean.Student> lstStudentWithSection;
    private java.util.List<bean.Student> lstStudentWithoutSection;
    private javax.persistence.Query personQuery;
    private javax.persistence.Query personQuery1;
    private javax.persistence.EntityManager schoolPUEntityManager;
    private java.util.List<bean.reference.Section> sectionList;
    private javax.persistence.Query sectionQuery;
    private javax.swing.JTable tblEnrolledStudent;
    private javax.swing.JTable tblEnrolledStudentSection;
    private component.JTextFieldPallete txtBoys;
    private component.JTextFieldPallete txtGirls;
    private component.JTextFieldPallete txtTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private JTable getNewTable() {
        JTable tbl = new JTable() {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
        };
        ToolTipManager.sharedInstance().unregisterComponent(tbl);
        ToolTipManager.sharedInstance().unregisterComponent(tbl.getTableHeader());
        return tbl;
    }
}
