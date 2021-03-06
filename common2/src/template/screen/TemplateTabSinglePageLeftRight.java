package template.screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.PanelUtil;

public class TemplateTabSinglePageLeftRight extends TemplateTabPage {
	@Override
	public Object getMainForm() {
	    useIndex = 0;
		super.getMainForm();
		myTab.removeAll();
//		if (myTab.getTabCount()>0) myTab.removeTabAt(0);
//		if (myTab.getTabCount()>0) myTab.removeTabAt(0);
//		if (myTab.getTabCount()>0) myTab.removeTabAt(0);
		JPanel pnl2 = new JPanel(new GridLayout(1,2,5,5));
		pnl2.add(pnlSearchPanel);
		pnl2.add(super.pnlTop);

		JPanel pnl3 = new JPanel(new GridLayout(2,1,5,5));
		pnl3.add(pnl2);
		pnl3.add(getSuperTabChildren());

		JPanel pnl = new JPanel(new BorderLayout(20,20));
		pnl.add(pnl3, BorderLayout.CENTER);
		pnl.add(super.pnlButton, BorderLayout.SOUTH);
		
		JPanel tmp = centerPanel(pnl);
		PanelUtil.updateColor(pnl2);
		PanelUtil.updateColor(pnl3);
		PanelUtil.updateColor(pnl);
		PanelUtil.updateColor(tmp);
		myTab.addTab("Main Form", tmp);
        myTab.addTab("Reports", pnlReportsPanel); // NOI18N
		return this;
	}

}
