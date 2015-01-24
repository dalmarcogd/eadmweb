package br.com.eadm.basic.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


@MappedSuperclass
public abstract class BasicEntity implements Serializable,Cloneable{

	private static final long serialVersionUID = -8800691172290762438L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	@Column(name = "version")
	private Timestamp version;

	public Long getId(){
		return this.id;
	}

	@Override
	public boolean equals(Object object) {
		if ((object instanceof BasicEntity) && ((BasicEntity) object).id == this.id) {
			return true;
		}
		return false;
	}	
	
}