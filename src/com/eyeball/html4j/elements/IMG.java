package com.eyeball.html4j.elements;

import java.util.ArrayList;

import com.eyeball.html4j.api.Attribute;
import com.eyeball.html4j.api.HTMLElement;
import com.eyeball.html4j.api.SourceHelper;

public class IMG extends HTMLElement {

	ArrayList<HTMLElement> children = new ArrayList<HTMLElement>();

	@Override
	public ArrayList<HTMLElement> getChildren() {
		return children;
	}

	@Override
	public String getElementTagName() {
		return "img";
	}

	@Override
	public String getSource(int spaces) {
		return SourceHelper.getSource(spaces, this);
	}

	@Override
	public void addElement(HTMLElement element) {
		children.add(element);
	}

	@Override
	public void removeElement(HTMLElement element) {
		children.remove(element);
	}

	@Attribute
	public String src = "";

	@Attribute
	public String alt = "";
}
