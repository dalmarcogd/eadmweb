package br.com.eadm.annotation;

import br.com.eadm.basic.entity.BasicEntity;


public @interface Entity {
	Class<? extends BasicEntity> value();
}
