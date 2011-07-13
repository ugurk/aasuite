/*
 * OtherPayment.java
 *
 * Created on March 25, 2009, 6:03 AM
 */

package ui.cashier;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import springbean.AAAConfig;
import ui.AbstractCashierForm;
import ui.CashierTransactionForm;
import util.BeanUtil;
import util.PanelUtil;
import util.DBClient;
import bean.Student;
import bean.accounting.BookSold;
import bean.accounting.CashierDailyBooklet;
import bean.accounting.Invoice;
import bean.accounting.Payment;
import rule.BookSold_RULE;

import component.JTextFieldPallete;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author  alex
 */
public class BookPayment extends javax.swing.JPanel implements IAcceptPaymentWindow {

    public AbstractCashierForm drawer;
    
    /** Creates new form OtherPayment */
    public BookPayment() {
        initComponents();
        try {
            PanelUtil.updateColor(pnlBookSold);
            PanelUtil.updateColor(jPanel1);
            PanelUtil.updateColor(jPanel2);
            PanelUtil.updateColor(this);

            jSplitPane1.setDividerSize(10);
            beanSoldBooks.view.tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
    

    private void changeSelectedRecord() {
        bean.accounting.BookSold pay = (bean.accounting.BookSold) beanSoldBooks.getBean();
        pnlBookSold.setBean(pay);
    }

    public static void main(String[] args) {
        java.awt.Color clr = new java.awt.Color(44, 117, 44);
        constants.Constants.panelBackground = clr;
        constants.Constants.labelColor = Color.WHITE;
        AAAConfig.getInstance();
        PanelUtil.displayToFrame(new BookPayment());
       
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlLeft = new javax.swing.JPanel();
        beanSoldBooks = new component.BeanPanelPallete();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new JTextFieldPallete();
        btnSearchNow = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlBookSold = new component.BeanPanelPallete();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCompleteSet = new javax.swing.JButton();
        btnClearBooks = new javax.swing.JButton();
        btnPrintOr = new javax.swing.JButton();

        jButton1.setText("Add Payment ");
        jButton1.setName("jButton1"); // NOI18N

        setBackground(new java.awt.Color(44, 117, 44));
        setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane1.setDividerLocation(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        pnlLeft.setName("pnlLeft"); // NOI18N
        pnlLeft.setLayout(new java.awt.BorderLayout());

        beanSoldBooks.setBeanName("BookSold");
        beanSoldBooks.setName("beanSoldBooks"); // NOI18N
        beanSoldBooks.setShowForm(false);
        beanSoldBooks.setShowImage(false);
        beanSoldBooks.setShowResult(true);

        javax.swing.GroupLayout beanSoldBooksLayout = new javax.swing.GroupLayout(beanSoldBooks);
        beanSoldBooks.setLayout(beanSoldBooksLayout);
        beanSoldBooksLayout.setHorizontalGroup(
            beanSoldBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        beanSoldBooksLayout.setVerticalGroup(
            beanSoldBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlLeft.add(beanSoldBooks, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N

        jLabel1.setText("Search:");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel3.add(jLabel1);

        txtSearch.setName("txtSearch"); // NOI18N
        txtSearch.setPreferredSize(new java.awt.Dimension(250, 20));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel3.add(txtSearch);

        btnSearchNow.setText("Search Now");
        btnSearchNow.setName("btnSearchNow"); // NOI18N
        btnSearchNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNowActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearchNow);

        pnlLeft.add(jPanel3, java.awt.BorderLayout.NORTH);

        jSplitPane1.setLeftComponent(pnlLeft);

        pnlRight.setName("pnlRight"); // NOI18N
        pnlRight.setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        pnlBookSold.setBeanName("BookSold");
        pnlBookSold.setName("pnlBookSold"); // NOI18N

        javax.swing.GroupLayout pnlBookSoldLayout = new javax.swing.GroupLayout(pnlBookSold);
        pnlBookSold.setLayout(pnlBookSoldLayout);
        pnlBookSoldLayout.setHorizontalGroup(
            pnlBookSoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        pnlBookSoldLayout.setVerticalGroup(
            pnlBookSoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.add(pnlBookSold);

        pnlRight.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(44, 117, 44));
        jPanel2.setName("jPanel2"); // NOI18N

        btnNew.setText("New");
        btnNew.setName("btnNew"); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew);

        btnCompleteSet.setText("Complete Set");
        btnCompleteSet.setName("btnCompleteSet"); // NOI18N
        btnCompleteSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteSetActionPerformed(evt);
            }
        });
        jPanel2.add(btnCompleteSet);

        btnClearBooks.setText("Clear Books");
        btnClearBooks.setName("btnClearBooks"); // NOI18N
        btnClearBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBooksActionPerformed(evt);
            }
        });
        jPanel2.add(btnClearBooks);

        btnPrintOr.setText("Print OR");
        btnPrintOr.setName("btnPrintOr"); // NOI18N
        btnPrintOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintOrActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrintOr);

        pnlRight.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setRightComponent(pnlRight);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents

private void btnPrintOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintOrActionPerformed
	CashierDailyBooklet booklet = CashierDailyBooklet.getMyBooklet();
    bean.accounting.BookSold pay = (bean.accounting.BookSold) pnlBookSold.getBean();
     if (pay.seq!=null && pay.seq>0 && pay.orNumber!=null && !pay.orNumber.isEmpty()) {
        pay.printOR("Official Receipt");
    }
    else {
//     if (pay.personId==0) {
//        PanelUtil.showError(btnPrintOr, "Please provide student.");
//        return;
//    }
    acceptCheck(pay);
    String or = PanelUtil.showPromptDefaultMessage(btnPrintOr, "Print OR, please check if OR number is correct.", BeanUtil.concat(booklet.extractNextOR("A")));
    if (or==null || or.isEmpty()) return;
    

	int i = Integer.parseInt(or);
	if (i<booklet.startMIS || i>booklet.endMIS) {
		if (!PanelUtil.showPrompt(this, "OR number out of series, would you like to continue?")) {
			return;
		}
	}
//	check or if exist in invoice
	Invoice inv = (Invoice) DBClient.getFirstRecord("SELECT a FROM Invoice a WHERE a.orNumber=",or," AND a.orType='A'");
	if (inv!=null && !inv.isEmptyKey()) {
		PanelUtil.showError(this, "OR# [",or,"] is already used, please check");
		return;
	}
    
    
//    pay.extractInvoice();
    pay.orNumber = or;
    pay.orType = "A";
    pay.orDate = constants.Constants.useDate;
    pay.printOR("Official Receipt");
    pnlBookSold.setBean(pay);
    drawer.updateDrawer();
} 
   
}//GEN-LAST:event_btnPrintOrActionPerformed

private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    pnlBookSold.setBean(new BookSold());
}//GEN-LAST:event_btnNewActionPerformed

private void btnCompleteSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteSetActionPerformed
    BookSold_RULE rule = (BookSold_RULE) pnlBookSold.view.ruleWrapper;
    BookSold book = (BookSold) pnlBookSold.getBean();
    book.completeSet = true;
    rule.completeSet();
}//GEN-LAST:event_btnCompleteSetActionPerformed

private void btnClearBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBooksActionPerformed
    BookSold book = (BookSold) pnlBookSold.getBean();
    int personId = book.personId;
    book = new BookSold();
    book.personId = personId;
    pnlBookSold.setBean(book);
}//GEN-LAST:event_btnClearBooksActionPerformed

private void btnSearchNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNowActionPerformed
    List lst = null;
    String txt = txtSearch.getText();
    if (txt==null || txt.trim().isEmpty()) {
        lst = DBClient.getList("SELECT a FROM BookSold a ORDER BY a.seq DESC");
    }
    else {
        lst = DBClient.getList("SELECT a FROM BookSold a WHERE a.payer LIKE '%",txt,"%' OR a.studentNumber = '",txt,"' ORDER BY a.seq DESC");
    }
    beanSoldBooks.setList(lst);
}//GEN-LAST:event_btnSearchNowActionPerformed

private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
    btnSearchNowActionPerformed(null);
}//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanSoldBooks;
    private javax.swing.JButton btnClearBooks;
    private javax.swing.JButton btnCompleteSet;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrintOr;
    private javax.swing.JButton btnSearchNow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane1;
    private component.BeanPanelPallete pnlBookSold;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    protected void acceptCheck(bean.accounting.BookSold p) {
        Student stud = (Student) DBClient.getFirstRecord("SELECT a FROM Student a WHERE a.personId=",p.personId);
        if (stud!=null && "NOT ALLOWED".equals(stud.paymentStatus)) {
            if (!PanelUtil.showPrompt(btnPrintOr, "Student cannot pay in check, would you like to continue?")) {
                return;
            }
        }
        else {
            boolean b = PanelUtil.showPrompt(btnPrintOr, "Are there any checks?");
            if (b) {
                Payment check = AcceptCheckForm.acceptCheck(new Student(), p.getTotalAmount(), 0);
                p.accountNumber1 = check.accountNumber1; 
                p.accountNumber2 = check.accountNumber2; 
                p.accountNumber3 = check.accountNumber3; 
                p.accountNumber4 = check.accountNumber4; 
                p.accountNumber5 = check.accountNumber5; 
                p.accountNumber6 = check.accountNumber6; 
                p.accountNumber7 = check.accountNumber7; 
                p.accountNumber8 = check.accountNumber8; 
                p.accountNumber9 = check.accountNumber9; 
                p.accountNumber10 = check.accountNumber10; 
                p.amount1 = check.amount1; 
                p.amount2 = check.amount2; 
                p.amount3 = check.amount3; 
                p.amount4 = check.amount4; 
                p.amount5 = check.amount5; 
                p.amount6 = check.amount6; 
                p.amount7 = check.amount7; 
                p.amount8 = check.amount8; 
                p.amount9 = check.amount9; 
                p.amount10 = check.amount10; 
            }
        }
    }


	public void reloadPayments() {
		// TODO Auto-generated method stub
		
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}


	public void searchOR(String or) {
		// TODO Auto-generated method stub
		
	}


	public void setDrawer(AbstractCashierForm form) {
		this.drawer = form;
	}


	public void setUseYear(String year) {
		// TODO Auto-generated method stub
		
	}
}