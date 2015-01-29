package br.com.eadm.rule.knowledge;

import java.util.ArrayList;
import java.util.List;

import br.com.eadm.exception.ValidationError;
import br.com.eadm.model.BasicEntity;
import br.com.eadm.rule.business.BasicBusinessRule;

public abstract class BaseKnowledge{
	
	
	private List<BasicBusinessRule> listSaveRules = new ArrayList<BasicBusinessRule>();
	private List<BasicBusinessRule> listDeleteRules = new ArrayList<BasicBusinessRule>();
	private List<BasicBusinessRule> listAlertRules = new ArrayList<BasicBusinessRule>();
	private List<ValidationError> listValidationError = new ArrayList<ValidationError>();
	
	public void addSaveRule(BasicBusinessRule basicBusinessRule) {
		listSaveRules.add(basicBusinessRule);
	}
	
	public void addDeleteRule(BasicBusinessRule basicBusinessRule) {
		listDeleteRules.add(basicBusinessRule);
	}
	
	public void addAlertRule(BasicBusinessRule basicBusinessRule) {
		listAlertRules.add(basicBusinessRule);
	}
	
	public List<ValidationError> validateSave(BasicEntity basicEntity) {
		for (BasicBusinessRule basicBusinessRule : listSaveRules) {
			listValidationError.add(basicBusinessRule.validate());
		}
		return listValidationError;
	}
	
	public List<ValidationError> validateDelete(BasicEntity basicEntity) {
		for (BasicBusinessRule basicBusinessRule : listDeleteRules) {
			listValidationError.add(basicBusinessRule.validate());
		}
		return listValidationError;
	}
	
	public List<ValidationError> validateAlert(BasicEntity basicEntity) {
		for (BasicBusinessRule basicBusinessRule : listAlertRules) {
			listValidationError.add(basicBusinessRule.validate());
		}
		return listValidationError;
	}
}
