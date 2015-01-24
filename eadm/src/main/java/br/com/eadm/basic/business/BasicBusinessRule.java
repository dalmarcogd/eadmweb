package br.com.eadm.basic.business;

import br.com.eadm.exception.ExceptionError;

public interface BasicBusinessRule {
	public ExceptionError validate();
}
