/*
 * ReportParameterViewer.java
 *
 * Created on March 9, 2008, 6:41 AM
 */

package component;

import component.*;
import component.AbstractReport;
//import component.reportdesigner.ReportDesigner;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author  Entokwaa
 */
public class ReportParameterViewer extends javax.swing.JPanel {
    JPanel reportViewer;
    JasperReport report;
    Map<String, JComponent> map = new HashMap<String, JComponent>();
    File file;
    
    public void showParameters(JasperReport report, JPanel reportViewer, File file) {
        this.report = report;
        this.reportViewer = reportViewer;
        this.file = file;
        List<JRParameter> params = AbstractReport.getReportParameters(report);
        List<JRParameter> paramSpecials = AbstractReport.getReportSpecialParameters(report);
        
        AbstractReport.putParameterToPanel(pnlParameter, params, map, false);
        AbstractReport.putParameterToPanel(pnlSpecial, paramSpecials, map, true);

        dlgViewer.pack();
        dlgViewer.setVisible(true);
    }
    
    /** Creates new form ReportParameterViewer */
    public ReportParameterViewer() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgViewer = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlParameter = new javax.swing.JPanel();
        pnlSpecial = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnShowReport = new javax.swing.JButton();

        dlgViewer.setTitle("Parameters"); // NOI18N
        dlgViewer.setAlwaysOnTop(true);
        dlgViewer.setModal(true);

        pnlParameter.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Report Parameter", pnlParameter);

        pnlSpecial.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Report Special Settings", pnlSpecial);

        btnShowReport.setText("Show Report"); // NOI18N
        btnShowReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowReportActionPerformed(evt);
            }
        });
        jPanel1.add(btnShowReport);

        javax.swing.GroupLayout dlgViewerLayout = new javax.swing.GroupLayout(dlgViewer.getContentPane());
        dlgViewer.getContentPane().setLayout(dlgViewerLayout);
        dlgViewerLayout.setHorizontalGroup(
            dlgViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap())
        );
        dlgViewerLayout.setVerticalGroup(
            dlgViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnShowReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowReportActionPerformed
    Map<String, Object> mapParam = new HashMap<String, Object>();
    for (String key:map.keySet()) {
        JComponent comp = map.get(key);
        if (comp instanceof JTextComponent) {
            JTextComponent txt = (JTextComponent) comp;
            mapParam.put(key, txt.getText());
        }
    }
    AbstractReport.displayReportToPanel(reportViewer, report, mapParam);
//    ReportDesigner.showMe(file);
}//GEN-LAST:event_btnShowReportActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowReport;
    private javax.swing.JDialog dlgViewer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlParameter;
    private javax.swing.JPanel pnlSpecial;
    // End of variables declaration//GEN-END:variables
    
}
