package br.com.eadm.ui.listener;


import br.com.eadm.ui.tree.TreeItem;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Tree;

public class TreeItemClickListener implements ItemClickListener {

	private static final long serialVersionUID = 862838574678889123L;
	private TabSheet tabSheet;
	
	public TreeItemClickListener(TabSheet tabSheet) {
		this.tabSheet = tabSheet;
	}
	
	@Override
	public void itemClick(ItemClickEvent event) {
		if (event.isDoubleClick() && ((Tree)event.getComponent()).getValue() != null) {
			TreeItem item = (TreeItem) ((Tree)event.getComponent()).getValue();
			
			Tab newTab = null;
			try {
				newTab = tabSheet.addTab((Component) item.getTabPage().newInstance(),item.getTitileTab(),item.getIconTab());
				newTab.setClosable(true);
				tabSheet.setSelectedTab(newTab);
				tabSheet.focus();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
