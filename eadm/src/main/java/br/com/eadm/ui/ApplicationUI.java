package br.com.eadm.ui;

import br.com.eadm.image.ImageIcons;
import br.com.eadm.ui.listener.TreeItemClickListener;
import br.com.eadm.ui.tree.TreeItem;
import br.com.eadm.view.usuario.UsuarioPageContent;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;


@Title(value="e-Adm")
@Theme("eadmtheme")
public class ApplicationUI extends UI {

	private static final long serialVersionUID = 2644967701384827101L;
	private VerticalSplitPanel page;
	private Panel panelTop;
	private HorizontalSplitPanel pageCenter;
	private Panel panelCenterLeft;
	private VerticalLayout panelCenterLeftLayout;
	private Tree tree;
	private Panel panelCenterRight;
	private TabSheet tabSheet;
	private VerticalLayout panelCenterRightLayout;
	
	@Override
	protected void init(VaadinRequest request) {
		initLayout();
		initPageTop();
		initPageCenter();
		initListeners();
	}
	
	private void initLayout(){
		page = new VerticalSplitPanel();
		page.setSplitPosition(100, Unit.PIXELS);
		page.setLocked(true);
		
		setContent(page);
	}
	
	private void initPageTop(){
		panelTop = new Panel();
		panelTop.setSizeFull();
		page.setFirstComponent(panelTop);
	}
	
	private void initPageCenter(){
		pageCenter = new HorizontalSplitPanel();
		pageCenter.setSizeFull();
		pageCenter.setLocked(false);
		pageCenter.setSplitPosition(200,Unit.PIXELS);
		pageCenter.setMinSplitPosition(150, Unit.PIXELS);
		pageCenter.setMaxSplitPosition(250, Unit.PIXELS);
		
		// cria um painel, layout vertical e uma tree, adiciona a tree dentro do layout e o layout dentro do panel
		panelCenterLeft = new Panel();
		panelCenterLeftLayout = new VerticalLayout();
		tree = new Tree();
		tree.setMultiSelect(false);
		
		TreeItem item = new TreeItem();
		item.setTitle("Teste2");
		item.setTitileTab("TEste2");
		item.setTabPage(UsuarioPageContent.class);
		item.setIconTab(ImageIcons.getResourceIcon("user.png"));
		tree.addItem(item);
		
		panelCenterLeftLayout.addComponent(tree);
		panelCenterLeft.setContent(panelCenterLeftLayout);
		panelCenterLeft.setSizeFull();

		pageCenter.setFirstComponent(panelCenterLeft);
		
		// cria um painel
		panelCenterRight = new Panel();
		panelCenterRightLayout = new VerticalLayout();
		tabSheet = new TabSheet();
		
		tabSheet.addTab(new VerticalLayout(), "teste");
		tabSheet.addTab(new VerticalLayout(), "teste1");
		
		
		panelCenterRightLayout.addComponent(tabSheet);
		panelCenterRight.setContent(panelCenterRightLayout);
		panelCenterRight.setSizeFull();
		
		pageCenter.setSecondComponent(panelCenterRight);
		
		page.setSecondComponent(pageCenter);
	}

	private void initListeners() {
		tree.addItemClickListener(new TreeItemClickListener(tabSheet));
	}
}

