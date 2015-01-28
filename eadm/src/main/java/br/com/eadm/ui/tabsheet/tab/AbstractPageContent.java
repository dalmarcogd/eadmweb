package br.com.eadm.ui.tabsheet.tab;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;

public class AbstractPageContent extends HorizontalSplitPanel {

	private static final long serialVersionUID = -8047778453870259981L;
	private Panel mainLeft;
	private Panel mainRight;
	
	public AbstractPageContent() {
		initLayout();
	}
	
	private void initLayout(){
		this.setSizeFull();
		this.setLocked(false);
		this.setSplitPosition(70, Unit.PERCENTAGE);
		this.setMinSplitPosition(65, Unit.PERCENTAGE);
		this.setMaxSplitPosition(75, Unit.PERCENTAGE);
	}
	
	public void setPanelFields(Panel panel){
		this.mainLeft = panel;
		super.setFirstComponent(this.mainLeft);
	}
	
	public void setPanelActions(Panel panel){
		this.mainRight = panel;
		super.setSecondComponent(this.mainRight);
	}
	
	@Override
	public void setFirstComponent(Component c) {
		if (c instanceof Panel) {
			setPanelFields((Panel) c);
		}
	}
	
	@Override
	public void setSecondComponent(Component c) {
		if (c instanceof Panel) {
			setPanelActions((Panel) c);
		}
	}
}
