package main;

import java.io.InputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.apache.jena.util.FileManager;

public class Functions {
	public static OntModel getOntologyModel(String ontoFile) {
		OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		try {
			InputStream in = FileManager.get().open(ontoFile);
			try {
				ontoModel.read(in, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Ontology " + ontoFile + " loaded.");
		} catch (JenaException je) {
			System.err.println("ERROR" + je.getMessage());
			je.printStackTrace();
			System.exit(0);
		}
		return ontoModel;
	}

	public static void performSPARQLQuery(Model model, String queryString) {

//		System.out.println(queryString);
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();

			ResultSetFormatter.out(System.out, results, query);
		}

	}
}
