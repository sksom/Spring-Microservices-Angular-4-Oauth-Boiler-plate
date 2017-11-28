package com.gift.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Registry implements Serializable {

	private static final long serialVersionUID = 99866854751313L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "registry_id", nullable = false, updatable = false)
	private long registryId;

	@ManyToMany
	@JoinTable(name = "registry_item", joinColumns = { @JoinColumn(name = "fk_registry") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_item") })
	private List<Item> registryItemList = new ArrayList<Item>();

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Registry(long registryId, List<Item> registryItemList, User user) {
		super();
		this.registryId = registryId;
		this.registryItemList = registryItemList;
		this.user = user;
	}

	public Registry() {
		super();
	}

	public long getRegistryId() {
		return registryId;
	}

	public void setRegistryId(long registryId) {
		this.registryId = registryId;
	}

	public List<Item> getRegistryItemList() {
		return registryItemList;
	}

	public void setRegistryItemList(List<Item> registryItemList) {
		this.registryItemList = registryItemList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addItem(Item item) {
		this.registryItemList.add(item);

	}

	public void removeItem(Item item) {
		this.registryItemList.remove(item);
	}

}
