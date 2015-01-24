

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;


public class GerarCPFAction implements ClickListener{

	private static final long serialVersionUID = -8062569046565047244L;
	private TextField textField;

	public GerarCPFAction(TextField textField) {
		this.textField = textField;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		textField.setValue(new GeraCPF().getCPF());
		
	}

	
}
