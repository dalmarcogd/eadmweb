package br.com.eadm.basic.business;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BasicBaseKnowledgeStorage {
	
	private static BasicBaseKnowledgeStorage storage;
	private List<BasicBaseKnowledge> listKnowledges;
	
	private BasicBaseKnowledgeStorage() {
		//listKnowledges.add()
		storage = this;
	}
	
	public static BasicBaseKnowledgeStorage getInstance(){
		if (storage == null) {
			storage = new BasicBaseKnowledgeStorage();
		}
		return storage;
	}

	public <T> BasicBaseKnowledge getKnowledge(Class<T> clas) {
		for (BasicBaseKnowledge basicBaseKnowledge : listKnowledges) {
			ParameterizedType genericSuperclass = (ParameterizedType) basicBaseKnowledge.getClass().getGenericSuperclass();
			Type type = genericSuperclass.getActualTypeArguments()[0];
			if (type.equals(clas)) {
				return basicBaseKnowledge;
			}
		}
		return null;
	}
}
