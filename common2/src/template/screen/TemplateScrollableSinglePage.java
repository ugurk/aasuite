/*
 * TemplateScrollableSinglePage.java
 *
 * Created on February 28, 2009, 8:43 AM
 */
package template.screen;

import component.ChartDisplayer;
import component.FileUploadRendererPallete;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JPanel;
import template.ChildRecord;
import template.ChildRecords;
import template.ParentAddInfo;
import util.Log;
import util.PanelUtil;

/**
 *
 * @author  Charliemagne Mark
 */
public class TemplateScrollableSinglePage extends TemplateTabPage {
    GridBagConstraints cons = new GridBagConstraints();

    protected void constructTabs() {
        pnlCenter.setLayout(new GridBagLayout());
        childRecordsAnnotation = (ChildRecords) currentClass.getAnnotation(ChildRecords.class);
        if (childRecordsAnnotation != null) {
            int countChild = childRecordsAnnotation.value() == null ? 0 : childRecordsAnnotation.value().length;
            int countInfo = childRecordsAnnotation.info() == null ? 0 : childRecordsAnnotation.info().length;
            if (countChild > 0 || countInfo > 0) {
                ParentAddInfo[] infos = childRecordsAnnotation.info();
                if (infos != null) {
                    for (ParentAddInfo info : infos) {
                        AbstractAddInfoTemplatePanel pnl = AbstractAddInfoTemplatePanel.getInstance(info, currentObject, tblResult, this);
                        JPanel tmp = new JPanel(new GridLayout());
                        tmp.add(pnl);
                        addChild(tmp, info.title(), cons);
                    }
                }
                ChildRecord[] records = childRecordsAnnotation.value();
                if (records != null) {
                    for (ChildRecord childRecord : records) {
                        AbstractChildTemplatePanel pnl = AbstractChildTemplatePanel.getInstance(childRecord, currentObject);
                        pnl.btnSave.setVisible(childRecord.canSave());
                        childPanels.add(pnl);
                        JPanel tmp = new JPanel(new GridLayout());
                        tmp.add(pnl);
                        if (childRecord.title().isEmpty()) {
                            addChild(tmp, PanelUtil.getTitle(childRecord.entity()), cons);
                        } else {
                            addChild(tmp, childRecord.title(), cons);
                        }
                    }
                }
            }
        }
        if (template.showFiles()) {
            filePallete = new FileUploadRendererPallete();
            filePallete.setName("files");
            bindPallete(filePallete);
            filePallete.setPreferredSize(new Dimension(template.imagesWidth(), template.imagesHeight()));
            JPanel pnl = new JPanel(new GridLayout());
            pnl.add(filePallete);
            addChild(pnl, "File Attachment", cons);
        }
        if (template.showChart()) {
            JPanel pnl = new ChartDisplayer(currentClass);
            pnl.setName("chart");
            bindPallete(pnl);
            addChild(pnl, "Charts", cons);
            Dimension pref = pnl.getPreferredSize();
            pref.height = 200;
            pnl.setPreferredSize(pref);
        }
        addChild(pnlButton, "", cons);
        Dimension pref = pnlButton.getPreferredSize();
        pref.height = 60;
        pnlButton.setPreferredSize(pref);
    }

    private void addChild(JPanel pnl, String title, GridBagConstraints cons) {
        cons.gridx = 0;
        cons.gridy++;
        cons.insets = new Insets(2, 2, 2, 2);
        cons.fill = GridBagConstraints.HORIZONTAL;
        Dimension dim = pnl.getPreferredSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dim.width = screenSize.width - 100;
        pnl.setPreferredSize(dim);
        Log.out("ADDING ",title);
        if (title!=null && !title.trim().isEmpty()) {
            GroupPanel pnlGroup = GroupPanel.construct(title, pnl, 1);
            pnlCenter.add(pnlGroup, cons);
            pnlGroup.hide();
        }
        else {
            pnlCenter.add(pnl, cons);
        }
    }

    @Override
    public Object getMainForm() {
        super.getMainForm();
        pnlNorth.add(pnlTop);
        return pnlThis;
    }

    /** Creates new form TemplateScrollableSinglePage */
    public TemplateScrollableSinglePage() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThis = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();

        pnlThis.setName("pnlThis"); // NOI18N
        pnlThis.setLayout(new java.awt.BorderLayout());

        pnlNorth.setName("pnlNorth"); // NOI18N
        pnlNorth.setLayout(new java.awt.GridLayout(1, 0));
        pnlThis.add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlCenter.setName("pnlCenter"); // NOI18N
        pnlCenter.setLayout(new java.awt.GridLayout(1, 0));
        pnlThis.add(pnlCenter, java.awt.BorderLayout.CENTER);

        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    protected javax.swing.JPanel pnlThis;
    // End of variables declaration//GEN-END:variables
}
