package com.nazmulhasanapu;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.nazmulhasanapu.model.USerModel;

public class WelcomePage extends WebPage {
	
	private static final long serialVersionUID = -522312620549216801L;
	
	private List<String> genderChoices = new ArrayList<String>();
	
	public WelcomePage(){
		
		genderChoices.add("Male");
		genderChoices.add("Female");
		USerModel uSerModel = new USerModel();
		
		Form <?> form = new Form("form");
		
		final TextField<String> text = new TextField<String>("text", new PropertyModel<String>(uSerModel, "name"));
		text.setOutputMarkupId(true);
		
		final DropDownChoice<String> gender = new DropDownChoice<String>("gender",
				new PropertyModel<String>(uSerModel, "gender"), genderChoices);
		gender.setOutputMarkupId(true);
		
		AjaxButton ajaxButton = new AjaxButton("submit") {
			@Override 
			protected void onSubmit(AjaxRequestTarget target, Form<?> form){
				super.onSubmit(target, form);
			
			
			text.setEnabled(false);
			gender.setEnabled(false);
			
			target.add(text);
			target.add(gender);
		
			}
		};
		
	/*	
		Button button = new Button("submit"){
			
			@Override
			public void onSubmit(){
				super.onSubmit();
				System.out.println("Name :" +uSerModel.getName());
				System.out.println("Gender :" +uSerModel.getGender());
			}
		}; */
		
		add(form);
		form.add(text);
		form.add(gender);
		form.add(ajaxButton);
		
		

	}
	
}
	
	
