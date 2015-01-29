package br.com.eadm.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.eadm.model.BasicEntity;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface KnowledgeEntity {

	Class<? extends BasicEntity> getType(); 
}
