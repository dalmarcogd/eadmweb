package br.com.eadm.ui.listener;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Tree;

public class TreeItemClickListener implements ItemClickListener {

	private static final long serialVersionUID = 862838574678889123L;
	private TabSheet tabSheet;
	private Tree tree;
	
	public TreeItemClickListener(TabSheet tabSheet,Tree tree) {
		this.tabSheet = tabSheet;
		this.tree = tree;
	}
	
	@Override
	public void itemClick(ItemClickEvent event) {
		if (event.isDoubleClick()) {
			System.out.println(tree.getValue());
		}
	}
	
}
