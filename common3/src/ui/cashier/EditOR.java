/*
 * EditOR.java
 *
 * Created on April 24, 2009, 10:47 PM
 */

package ui.cashier;

import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.UserInfo;
import bean.accounting.Invoice;
import bean.accounting.PaymentPlan;
import template.report.AbstractReportTemplate;
import ui.AbstractCashierForm;
import util.BeanUtil;
import util.DBClient;
import util.DataUtil;
import util.PanelUtil;

/**
 *
 * @author  Alex Miranda
 */
public class EditOR extends javax.swing.JPanel implements IAcceptPaymentWindow {
	public void searchOR(String or) {
		txtORNumber.setText(or);
		txtORNumberActionPerformed(null);
	}
	
    /** Creates new form EditOR */
    public EditOR() {
        initComponents();
        jSplitPane1.setDividerSize(10);
        try {
        	if (!UserInfo.canLockInvoice()) {
        		btnLockInvoice.setVisible(false);
        		btnUnlockInvoice.setVisible(false);
        		btnPaymentPlan.setVisible(false);
        	}
        	else {
        		btnLockInvoice.setVisible(true);
        		btnUnlockInvoice.setVisible(true);
        	}
            beanPanelPallete1.view.tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        changeSelectedRecord();
                    }
                }
            });
        }
        catch (Exception e) {
        }
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSaveOR = new javax.swing.JButton();
        btnCancelOR = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnLockInvoice = new javax.swing.JButton();
        btnUnlockInvoice = new javax.swing.JButton();
        btnPaymentPlan = new javax.swing.JButton();
        btnReprintOR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlInvoice = new component.BeanPanelPallete();
        pnlTopInvoice = new component.BeanPanelPallete();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtORNumber = new javax.swing.JTextField();
        beanPanelPallete1 = new component.BeanPanelPallete();

        setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane1.setDividerLocation(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N

        btnSaveOR.setText("Save OR");
        btnSaveOR.setName("btnSaveOR"); // NOI18N
        btnSaveOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveORActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveOR);

        btnCancelOR.setText("Cancel OR");
        btnCancelOR.setName("btnCancelOR"); // NOI18N
        btnCancelOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelORActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelOR);

        lblStatus.setText("--");
        lblStatus.setName("lblStatus"); // NOI18N
        jPanel1.add(lblStatus);

        btnLockInvoice.setText("Lock OR");
        btnLockInvoice.setName("btnLockInvoice"); // NOI18N
        btnLockInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockInvoiceActionPerformed(evt);
            }
        });
        jPanel1.add(btnLockInvoice);

        btnUnlockInvoice.setText("Unlock OR");
        btnUnlockInvoice.setName("btnUnlockInvoice"); // NOI18N
        btnUnlockInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnlockInvoiceActionPerformed(evt);
            }
        });
        jPanel1.add(btnUnlockInvoice);

        btnPaymentPlan.setText("Payment Plan");
        btnPaymentPlan.setName("btnPaymentPlan"); // NOI18N
        btnPaymentPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentPlanActionPerformed(evt);
            }
        });
        jPanel1.add(btnPaymentPlan);

        btnReprintOR.setText("Reprint OR");
        btnReprintOR.setName("btnReprintOR"); // NOI18N
        btnReprintOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReprintORActionPerformed(evt);
            }
        });
        jPanel1.add(btnReprintOR);

        jPanel4.add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        pnlInvoice.setBeanName("InvoiceExt");
        pnlInvoice.setName("pnlInvoice"); // NOI18N
        pnlInvoice.setShowImage(false);
        pnlInvoice.setShowSubRecords(true);

        javax.swing.GroupLayout pnlInvoiceLayout = new javax.swing.GroupLayout(pnlInvoice);
        pnlInvoice.setLayout(pnlInvoiceLayout);
        pnlInvoiceLayout.setHorizontalGroup(
            pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        pnlInvoiceLayout.setVerticalGroup(
            pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel3.add(pnlInvoice, java.awt.BorderLayout.CENTER);

        pnlTopInvoice.setBeanName("InvoiceExt");
        pnlTopInvoice.setName("pnlTopInvoice"); // NOI18N
        pnlTopInvoice.setShowImage(false);

        javax.swing.GroupLayout pnlTopInvoiceLayout = new javax.swing.GroupLayout(pnlTopInvoice);
        pnlTopInvoice.setLayout(pnlTopInvoiceLayout);
        pnlTopInvoiceLayout.setHorizontalGroup(
            pnlTopInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        pnlTopInvoiceLayout.setVerticalGroup(
            pnlTopInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(pnlTopInvoice, java.awt.BorderLayout.NORTH);

        jPanel4.add(jPanel3, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel4);

        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("OR #:");
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        txtORNumber.setName("txtORNumber"); // NOI18N
        txtORNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtORNumberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel2.add(txtORNumber, gridBagConstraints);

        jPanel5.add(jPanel2, java.awt.BorderLayout.NORTH);

        beanPanelPallete1.setBeanName("InvoiceExt");
        beanPanelPallete1.setName("beanPanelPallete1"); // NOI18N
        beanPanelPallete1.setShowForm(false);
        beanPanelPallete1.setShowImage(false);
        beanPanelPallete1.setShowResult(true);

        javax.swing.GroupLayout beanPanelPallete1Layout = new javax.swing.GroupLayout(beanPanelPallete1);
        beanPanelPallete1.setLayout(beanPanelPallete1Layout);
        beanPanelPallete1Layout.setHorizontalGroup(
            beanPanelPallete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        beanPanelPallete1Layout.setVerticalGroup(
            beanPanelPallete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(beanPanelPallete1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel5);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents

private void txtORNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtORNumberActionPerformed
    String or = txtORNumber.getText().toUpperCase();
    StringBuffer sb = new StringBuffer();
    if (or.contains("-") && or.startsWith("A")) {
    	String ortmp = or.substring(or.indexOf("-")+1).trim();
    	sb.append("SELECT a FROM Invoice a WHERE (a.orNumber=").append(ortmp).append(") ");
    }
    else {
    	sb.append("SELECT a FROM Invoice a WHERE (a.orNumber=").append(or).append(") ");
    }
    sb.append(" OR a.checkNumber LIKE '%").append(or).append("-%' ");
//    sb.append(" OR a.accountNumber2='").append(or).append("' ");
//    sb.append(" OR a.accountNumber3='").append(or).append("' ");
//    sb.append(" OR a.accountNumber4='").append(or).append("' ");
//    sb.append(" OR a.accountNumber5='").append(or).append("' ");
//    sb.append(" OR a.accountNumber6='").append(or).append("' ");
//    sb.append(" OR a.accountNumber7='").append(or).append("' ");
//    sb.append(" OR a.accountNumber8='").append(or).append("' ");
//    sb.append(" OR a.accountNumber9='").append(or).append("' ");
//    sb.append(" OR a.accountNumber10='").append(or).append("' ");
    List<Invoice> lst = DBClient.getList(sb.toString());
    beanPanelPallete1.setList((List)lst);
}//GEN-LAST:event_txtORNumberActionPerformed

protected void changeSelectedRecord() {
	Invoice inv = (Invoice) beanPanelPallete1.getBean();

    pnlInvoice.setBean(inv);
    pnlTopInvoice.setBean(inv);
    if (inv==null) return;
    if (inv.isLocked()) {
    	lblStatus.setText("LOCKED");
    	btnSaveOR.setEnabled(false);
    	btnCancelOR.setEnabled(false);
    	btnLockInvoice.setEnabled(false);
    	btnUnlockInvoice.setEnabled(true);
    }
    else {
    	lblStatus.setText("");
    	btnSaveOR.setEnabled(true);
    	btnCancelOR.setEnabled(true);
    	btnLockInvoice.setEnabled(true);
    	btnUnlockInvoice.setEnabled(false);
    }
    if (inv.cancelled) {
        lblStatus.setText(BeanUtil.concat(lblStatus.getText(),"-CANCELLED"));
        btnCancelOR.setEnabled(false);
    } 
    if (!UserInfo.canLockInvoice()) {
        if (!UserInfo.getUserName().equals(inv.cashier)) {
            btnSaveOR.setEnabled(false);
            btnCancelOR.setEnabled(false);
        }
    }
}

private void btnSaveORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveORActionPerformed
    Invoice p = (Invoice) pnlInvoice.getBean();
    p.adjustedBy = UserInfo.getUserName();
    p.adjustedDate = new Date();
    p.save();
}//GEN-LAST:event_btnSaveORActionPerformed

private void btnLockInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockInvoiceActionPerformed
	Invoice inv = (Invoice) pnlInvoice.getBean();
	inv.locked = true;
	inv.save();
	txtORNumberActionPerformed(null);
}//GEN-LAST:event_btnLockInvoiceActionPerformed

private void btnUnlockInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnlockInvoiceActionPerformed
	Invoice inv = (Invoice) pnlInvoice.getBean();
	inv.locked = false;
	inv.save();
	txtORNumberActionPerformed(null);
}//GEN-LAST:event_btnUnlockInvoiceActionPerformed

private void btnCancelORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelORActionPerformed
    if (!PanelUtil.showPrompt(this, "Do you want to cancel this OR?"))  {
    	return;
    }
    Invoice inv = (Invoice) pnlInvoice.getBean();
    inv.cancelled = true;
    inv.totalAmount = inv.allAmount = inv.checkAmount = inv.discount = 0;
    inv.payer = "***CANCELLED***";
    int billTo = DataUtil.getIntValue(inv.billTo);
    inv.billTo = "0";
    inv.checkAmtNumber = "";
    inv.checkNumber = "";
    if (PanelUtil.showPrompt(this, "Would you like to reuse this cancelled OR?\nNote: OR Number will be -1 if you choose Yes."))  {
    	inv.orNumber = "-1";
    }
    inv.save();
//        need to change all the payment to cancelled
    DBClient.runSQLNative("UPDATE Payment SET orNumber=-1, orAmount=0, amountPaid=0, oldPaymentFor=paymentFor , paymentFor='",constants.Constants.CANCELLED,"' WHERE invoiceId=",inv.seq);
//    need to revert the payment back from assessment
    List lst = DBClient.getList(BeanUtil.concat("SELECT a FROM Payment a WHERE a.schoolYear='",inv.schoolYear,"' AND a.paidBy=",billTo," AND a.paid=false"));
    DBClient.persistBean(lst);
    txtORNumberActionPerformed(null);
}//GEN-LAST:event_btnCancelORActionPerformed

private void btnPaymentPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentPlanActionPerformed
	PanelUtil.popupBeanTemplate(PaymentPlan.class, "Payment Plan", true);
}//GEN-LAST:event_btnPaymentPlanActionPerformed

private void btnReprintORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprintORActionPerformed
    Invoice inv = (Invoice) pnlInvoice.getBean();
    inv.printOR("Reprint Official Receipt");
}//GEN-LAST:event_btnReprintORActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanPanelPallete1;
    private javax.swing.JButton btnCancelOR;
    private javax.swing.JButton btnLockInvoice;
    public javax.swing.JButton btnPaymentPlan;
    private javax.swing.JButton btnReprintOR;
    private javax.swing.JButton btnSaveOR;
    private javax.swing.JButton btnUnlockInvoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblStatus;
    private component.BeanPanelPallete pnlInvoice;
    private component.BeanPanelPallete pnlTopInvoice;
    private javax.swing.JTextField txtORNumber;
    // End of variables declaration//GEN-END:variables
	public void reloadPayments() {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void setDrawer(AbstractCashierForm form) {
		// TODO Auto-generated method stub
		
	}

	public void setUseYear(String year) {
		// TODO Auto-generated method stub
		
	}

}