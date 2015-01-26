package br.com.eadm.view.usuario;

import com.vaadin.ui.Panel;

import br.com.eadm.ui.page.tab.content.AbstractPageContent;

public class UsuarioPageContent extends AbstractPageContent {

	private static final long serialVersionUID = -7632328177839988032L;
	
	public UsuarioPageContent() {
		Panel p = new Panel();
		setPanelFields(p);
		Panel p2 = new Panel();
		setPanelActions(p2);
	}
}
