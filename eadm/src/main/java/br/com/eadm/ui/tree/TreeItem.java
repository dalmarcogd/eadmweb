package br.com.eadm.ui.tree;

import com.vaadin.ui.VerticalLayout;

public class TreeItem {
	private VerticalLayout tabPage;
	private String title;
	
	public VerticalLayout getTabPage() {
		return tabPage;
	}

	public void setTabPage(VerticalLayout tabPage) {
		this.tabPage = tabPage;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
