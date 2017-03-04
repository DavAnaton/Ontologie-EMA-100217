package main;

import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.riot.RDFDataMgr;

public class Main {

	public static void main(String[] args) {
		String onto_file = System.getProperty("user.dir") + "/ressources/seriev7.owl";
		String data_file = System.getProperty("user.dir") + "/ressources/datav1.nt";

		Model model = RDFDataMgr.loadModel(onto_file);
		RDFDataMgr.read(model, data_file);

		// Select Categorie
		Search queryParams = new Search("Serie");
		// Add as many params as you want
//		queryParams.addActor("JamesFranco");
//		queryParams.addNationality("Grande-Bretagne");
		queryParams.addProducer("Producteur1");
//		queryParams.setAnneeDebut("2012");
		queryParams.setIsAiredOn("Web");
		
		// Generate Query
		String query = queryParams.search();
		
//		Reasoner
		Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
		InfModel inf = ModelFactory.createInfModel(reasoner, model);

//		query = "SELECT ?Serie ?x WHERE { ?Serie <http://www.ema.com/ontologies/series#nbSaisons> ?x }";
		Functions.performSPARQLQuery(inf, query);
	}

}
