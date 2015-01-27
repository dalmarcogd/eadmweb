package br.com.eadm.basic.business;

import br.com.eadm.exception.ValidationError;


public interface BasicBusinessRule {
	public ValidationError validate();
}
