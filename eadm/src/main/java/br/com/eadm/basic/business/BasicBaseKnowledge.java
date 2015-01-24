package br.com.eadm.basic.business;

import java.util.List;

import br.com.eadm.exception.ExceptionError;

public interface BasicBaseKnowledge {
	public void addRule(BasicBusinessRule basicBusinessRule);
	public List<ExceptionError> validateAllRules();
	public Object getObject();
}
