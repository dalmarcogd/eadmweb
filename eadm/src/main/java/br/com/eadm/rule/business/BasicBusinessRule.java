package br.com.eadm.rule.business;

import br.com.eadm.exception.ValidationError;


public interface BasicBusinessRule {
	public ValidationError validate();
}
