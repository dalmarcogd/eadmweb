package br.com.eadm.basic.dao;

import java.util.List;

import br.com.eadm.basic.entity.BasicEntity;
import br.com.eadm.exception.ValidationError;

public interface BasicDAO {
	public List<ValidationError> delete(BasicEntity basicEntity);
	public List<ValidationError> save(BasicEntity basicEntity);
}
