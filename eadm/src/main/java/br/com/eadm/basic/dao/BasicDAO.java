package br.com.eadm.basic.dao;

import br.com.eadm.basic.business.BasicBaseKnowledge;

public interface BasicDAO {
	public void update(BasicBaseKnowledge knowledge);
	public void delete(BasicBaseKnowledge knowledge);
	public void save(BasicBaseKnowledge knowledge);
}
