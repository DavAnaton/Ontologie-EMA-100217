package main;

import java.util.ArrayList;

public class Search {
	private String category;
	
	private ArrayList<String> actors;
	private ArrayList<String> nationalities;
	private ArrayList<String> distinctions;
	private ArrayList<String> originalLanguages;
	private ArrayList<String> producers;
	private ArrayList<String> themes;
	
	private String state;
	private String isAiredOn;
	private String realisator;
	private String anneeDebut;
	
	public Search(){
		this.category = "Serie";
		this.actors = new ArrayList<String>();
		this.nationalities = new ArrayList<String>();
		this.distinctions = new ArrayList<String>();
		this.originalLanguages = new ArrayList<String>();
		this.producers = new ArrayList<String>();
		this.themes = new ArrayList<String>();
		
		this.state = null;
		this.isAiredOn = null;
		this.realisator = null;
		this.anneeDebut = null;
	}
	
	public Search(String category){
		this();
		this.category = category;
	}
	
	public String search() {
		String query = "SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#" + this.category + "> ";

		// Actors
		if (this.actors != null && this.actors.size() > 0) {
			for (String actor : this.actors) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasActor> <http://www.ema.com/ontologies/series#"
						+ actor + "> ";
			}
		}

		// Nationality
		if (this.nationalities != null && this.nationalities.size() > 0) {
			for (String nationality : this.nationalities) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasNationality> <http://www.ema.com/ontologies/series#"
						+ nationality + "> ";
			}
		}
		
		// Distinction
		if (this.distinctions != null && this.distinctions.size() > 0) {
			for (String distinction : this.distinctions) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasDistinction> <http://www.ema.com/ontologies/series#"
						+ distinction + "> ";
			}
		}

		// OriginalLanguage
		if (this.originalLanguages != null && this.originalLanguages.size() > 0) {
			for (String originalLanguage : this.originalLanguages) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasOriginalLanguage> <http://www.ema.com/ontologies/series#"
						+ originalLanguage + "> ";
			}
		}
		
		// Producer
		if (this.producers != null && this.producers.size() > 0) {
			for (String producer : this.producers) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#isProducedBy> <http://www.ema.com/ontologies/series#"
						+ producer + "> ";
			}
		}
		
		// Theme
		if (this.themes != null && this.themes.size() > 0) {
			for (String theme : this.themes) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasTheme> <http://www.ema.com/ontologies/series#"
						+ theme + "> ";
			}
		}

		// State
		if (this.state != null) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasState> <http://www.ema.com/ontologies/series#"
						+ state + "> ";
		}

		// IsAiredOn
		if (this.isAiredOn != null) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#isAiredOn> <http://www.ema.com/ontologies/series#"
						+ isAiredOn + "> ";
		}

		// Realisator
		if (this.realisator != null) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#hasRealisator> <http://www.ema.com/ontologies/series#"
						+ realisator + "> ";
		}

		// AnneeDebut
		if (this.anneeDebut != null) {
				query += ". ?Serie <http://www.ema.com/ontologies/series#anneeDebut> ?x . FILTER(?x >= "+
				this.anneeDebut + ")";
		}
				
		query += "}";
		System.out.println(query);
		return query;
	}

	public void addActor(String a){
		if(this.actors.indexOf(a) == -1){
			this.actors.add(a);
			
		}
	}

	public void addNationality(String a){
		if(this.nationalities.indexOf(a) == -1){
			this.nationalities.add(a);
			
		}
	}
	
	public void addDistinction(String a){
		if(this.distinctions.indexOf(a) == -1){
			this.distinctions.add(a);
			
		}
	}
	
	public void addOriginalLanguage(String a){
		if(this.originalLanguages.indexOf(a) == -1){
			this.originalLanguages.add(a);
			
		}
	}
	
	public void addProducer(String a){
		if(this.producers.indexOf(a) == -1){
			this.producers.add(a);
			
		}
	}
	
	public void addTheme(String a){
		if(this.themes.indexOf(a) == -1){
			this.themes.add(a);
			
		}
	}
	
	public void setState(String a){
		this.state = a;
	}
	
	public void setIsAiredOn(String a){
		this.isAiredOn = a;
	}
	
	public void setRealisator(String a){
		this.realisator = a;
	}
	
	public void setAnneeDebut(String a){
		this.anneeDebut = a;
	}

}
