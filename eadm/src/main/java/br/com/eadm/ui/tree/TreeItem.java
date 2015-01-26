package br.com.eadm.ui.tree;

import com.vaadin.server.Resource;

public class TreeItem {
	private Class<?> tabPage;
	private String title;
	private String titileTab;
    private Resource iconTab;
	
	public Class<?> getTabPage() {
		return tabPage;
	}

	public void setTabPage(Class<?> tabPage) {
		this.tabPage = tabPage;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getTitileTab() {
		return titileTab;
	}

	public void setTitileTab(String titileTab) {
		this.titileTab = titileTab;
	}
	
	@Override
	public String toString() {
		return this.title;
	}

	public Resource getIconTab() {
		return iconTab;
	}

	public void setIconTab(Resource iconTab) {
		this.iconTab = iconTab;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
