package br.com.eadm.basic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import br.com.eadm.annotation.KnowledgeEntity;
import br.com.eadm.basic.entity.BasicEntity;
import br.com.eadm.exception.ValidationError;
import br.com.eadm.rule.knowledge.BaseKnowledge;

public class AbstractDAO<T extends BasicEntity> implements BasicDAO{
	
	private T t;
		
	@Override
	public List<ValidationError> delete(BasicEntity basicEntity) {
		Reflections reflections = new Reflections("br/com/eadm/rule/knowledge/");
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(KnowledgeEntity.class);
		
		List<ValidationError> listValidationErrors = new ArrayList<ValidationError>();
		for (Class<?> class1 : typesAnnotatedWith) {
			if (t.getClass().equals(class1.getAnnotation(KnowledgeEntity.class).getType())){
				try {
					BaseKnowledge knowledge = (BaseKnowledge) class1.newInstance();
					listValidationErrors = knowledge.validateDelete(basicEntity);
				} catch (Exception e) {

				}
			}
		}
		return listValidationErrors;		
	}   

	@Override
	public List<ValidationError> save(BasicEntity basicEntity) {
		return null;
		//BaseKnowledge knowledge = BaseKnowledgeStorage.getInstance().getKnowledge(t.getClass());
		//return knowledge.validateSave(basicEntity);
	}

}
