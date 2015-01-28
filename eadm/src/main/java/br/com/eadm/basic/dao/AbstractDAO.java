package br.com.eadm.basic.dao;

import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import br.com.eadm.annotation.KnowledgeEntity;
import br.com.eadm.basic.entity.BasicEntity;
import br.com.eadm.exception.ValidationError;

public class AbstractDAO implements BasicDAO{

		
	@Override
	public List<ValidationError> delete(BasicEntity basicEntity) {
		Reflections reflections = new Reflections("br/com/eadm/rule/knowledge/");
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(KnowledgeEntity.class);
		
		for (Class<?> class1 : typesAnnotatedWith) {
			if (basicEntity.getClass() == class1.getAnnotation(KnowledgeEntity.class).getType()){
				//BaseKnowledge knowledge =  
			}
		}
		return null;
		
		
	}   

	@Override
	public List<ValidationError> save(BasicEntity basicEntity) {
		return null;
		//BaseKnowledge knowledge = BaseKnowledgeStorage.getInstance().getKnowledge(t.getClass());
		//return knowledge.validateSave(basicEntity);
	}

}
