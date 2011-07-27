/*
 * AbstractTemplatePanel.java
 *
 * Created on August 24, 2008, 6:58 AM
 */

package template.screen;

import javax.swing.JPanel;
import template.screen.component.JTableReadOnly;

/**
 *
 * @author  Entokwaa
 */
public class TemplateSearchOnlyNoCriteria extends AbstractTemplatePanel {
    @Override
    public Object getMainForm() {
        super.getMainForm();
        pnlMainForm.removeAll();
        pnlCriteria.removeAll();
        pnlResults.removeAll();
        pnlButton.removeAll();  
        pnlChildTab.removeAll();
        
        GroupPanel pnlCrit = GroupPanel.construct("Result", (JPanel)super.getMainSearchResult(), tblResult);
        pnlCriteria.add(pnlCrit);
        pnlResults.setVisible(false);
        pnlButton.add(super.pnlButton);
        
        pnlChildTab.add(super.tabChildren);
        pnlChildTab.setVisible(super.tabChildren.isVisible());
        return this;
    }

    @Override
    public Object getMainSearch() {
        return new JPanel();
    }

    @Override
    public Object getMainSearchResult() {
        return new JPanel();
    }

    /** Creates new form AbstractTemplatePanel */
    public TemplateSearchOnlyNoCriteria() {
        initComponents();
        if (constants.Constants.panelBackground!=null) {
            setBackground(constants.Constants.panelBackground);
            if (pnlChildTab!=null) pnlChildTab.setBackground(constants.Constants.panelBackground);
            if (pnlImages!=null) pnlImages.setBackground(constants.Constants.panelBackground);
            if (pnlButton!=null) pnlButton.setBackground(constants.Constants.panelBackground);
            if (pnlCriteria!=null) pnlCriteria.setBackground(constants.Constants.panelBackground);
            if (pnlMainForm!=null) pnlMainForm.setBackground(constants.Constants.panelBackground);
            if (pnlResults!=null) pnlResults.setBackground(constants.Constants.panelBackground);
            if (pnlTop!=null) pnlTop.setBackground(constants.Constants.panelBackground);
            if (pnlTopWithTab!=null) pnlTopWithTab.setBackground(constants.Constants.panelBackground);
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

        jPanel3 = new javax.swing.JPanel();
        pnlChildTab = new javax.swing.JPanel();
        tabChildren = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnlButton = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new JTableReadOnly(35);
        pnlTop = new javax.swing.JPanel();
        pnlImages = new javax.swing.JPanel();
        pnlMainForm = new javax.swing.JPanel();
        pnlTopWithTab = new javax.swing.JPanel();
        pnlCriteria = new javax.swing.JPanel();
        pnlResults = new javax.swing.JPanel();

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        pnlChildTab.setName("pnlChildTab"); // NOI18N
        pnlChildTab.setLayout(new java.awt.GridLayout(1, 0));

        tabChildren.setName("tabChildren"); // NOI18N
        tabChildren.setPreferredSize(new java.awt.Dimension(500, 35));

        jPanel1.setName("jPanel1"); // NOI18N
        tabChildren.addTab("Child 1", jPanel1);

        pnlChildTab.add(tabChildren);

        pnlButton.setName("pnlButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblResult.setAutoCreateRowSorter(true);
        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResult.setName("tblResult"); // NOI18N
        tblResult.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblResult);

        pnlTop.setName("pnlTop"); // NOI18N
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlImages.setName("pnlImages"); // NOI18N
        pnlImages.setLayout(new java.awt.GridBagLayout());

        pnlMainForm.setName("pnlMainForm"); // NOI18N
        pnlMainForm.setLayout(new java.awt.GridBagLayout());

        pnlTopWithTab.setName("pnlTopWithTab"); // NOI18N

        javax.swing.GroupLayout pnlTopWithTabLayout = new javax.swing.GroupLayout(pnlTopWithTab);
        pnlTopWithTab.setLayout(pnlTopWithTabLayout);
        pnlTopWithTabLayout.setHorizontalGroup(
            pnlTopWithTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        pnlTopWithTabLayout.setVerticalGroup(
            pnlTopWithTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        setName("Form"); // NOI18N

        pnlCriteria.setName("pnlCriteria"); // NOI18N
        pnlCriteria.setLayout(new java.awt.GridLayout());

        pnlResults.setName("pnlResults"); // NOI18N
        pnlResults.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCriteria, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(pnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel pnlButton;
    public javax.swing.JPanel pnlChildTab;
    public javax.swing.JPanel pnlCriteria;
    private javax.swing.JPanel pnlImages;
    public javax.swing.JPanel pnlMainForm;
    public javax.swing.JPanel pnlResults;
    public javax.swing.JPanel pnlTop;
    public javax.swing.JPanel pnlTopWithTab;
    public javax.swing.JTabbedPane tabChildren;
    public javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
