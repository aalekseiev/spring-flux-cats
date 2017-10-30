package com.murkino.demoflux;

import java.time.LocalDate;

public class Cat {

	private Long id;

	private LocalDate createDate;

	private String name;

	private String color;

	public Cat() {

	}

	public Cat(Long id, String name, String color) {
		super();
		this.id = id;
		this.createDate = LocalDate.now();
		this.name = name;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", createDate=" + createDate + ", name=" + name + ", color=" + color + "]";
	}

}
