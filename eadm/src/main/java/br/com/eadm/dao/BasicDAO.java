package br.com.eadm.dao;

import java.util.List;

import br.com.eadm.exception.ValidationError;
import br.com.eadm.model.BasicEntity;

public interface BasicDAO {
	public List<ValidationError> delete(BasicEntity basicEntity);
	public List<ValidationError> save(BasicEntity basicEntity);
}
