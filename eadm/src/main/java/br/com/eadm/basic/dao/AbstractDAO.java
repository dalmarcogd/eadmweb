package br.com.eadm.basic.dao;

import java.util.List;

import br.com.eadm.basic.business.BasicBaseKnowledge;
import br.com.eadm.basic.business.BasicBaseKnowledgeStorage;
import br.com.eadm.basic.entity.BasicEntity;
import br.com.eadm.exception.ValidationError;

public class AbstractDAO<T extends BasicEntity> implements BasicDAO{
	
	private T t;
		
	@Override
	public List<ValidationError> delete(BasicEntity basicEntity) {
		BasicBaseKnowledge knowledge = BasicBaseKnowledgeStorage.getInstance().getKnowledge(t.getClass());
		return knowledge.validateDelete(basicEntity);
	}   

	@Override
	public List<ValidationError> save(BasicEntity basicEntity) {
		BasicBaseKnowledge knowledge = BasicBaseKnowledgeStorage.getInstance().getKnowledge(t.getClass());
		return knowledge.validateSave(basicEntity);
	}

}
