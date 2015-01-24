package br.com.eadm.ui;

import br.com.eadm.hibernate.HibernateTools;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;


@Title(value="e-Adm")
@Theme("eadmtheme")
public class ApplicationUI extends UI {

	private static final long serialVersionUID = 2644967701384827101L;
	private VerticalSplitPanel vertical;
	

	@Override
	protected void init(VaadinRequest request) {
		initLayout();
		Panel panelTop = new Panel();
		panelTop.setHeight("100px");
		
		vertical.setFirstComponent(panelTop);
		
		HorizontalSplitPanel center = new HorizontalSplitPanel();
		center.setSizeFull();
		center.setLocked(false);
		center.setSplitPosition(200,Unit.PIXELS);
		
		Panel panelLeft = new Panel();
		VerticalLayout verticalLeft = new VerticalLayout();
		Tree tree = new Tree();

		tree.addItem("teste");
		verticalLeft.addComponent(tree);
		
		panelLeft.setContent(verticalLeft);
		panelLeft.setSizeFull();

		center.setFirstComponent(panelLeft);	
		
		Panel panelCenter = new Panel();
		panelCenter.setSizeFull();
		
		center.setSecondComponent(panelCenter);
		
		vertical.setSecondComponent(center);
		
		
		HibernateTools.getSessionFactory().openSession();
	}
	
	public void initLayout(){
		vertical = new VerticalSplitPanel();
		vertical.setSplitPosition(100, Unit.PIXELS);
		vertical.setLocked(true);
		
		setContent(vertical);
	}

}
