var parse = require('csv-parse'),
	fs = require('fs');
var dataNt = "";

var index = {};
index[0] ="serie";
index[1] ="hasNationality";
index[2] ="isProducedBy";
index[3] ="isAiredOn";
index[4] ="hasActor";
index[5] ="hasState";
index[6] ="isRealizedBy";
index[7] ="hasOriginalLanguage";
index[8] ="isInspiredBy";
index[9] ="hasDistinction";
index[10] ="hasTheme";

var startAttributes = 11;
index[11] ="dureeEpisode";
index[12] ="note";
index[13] ="anneeDebut";
index[14] ="nbVue";
index[15] ="nbSaison";

fs.readFile('data.csv', 'utf8', function(err, file){
	parse(file, {delimiter: ';'}, function(err, data){
		data.shift();
		data.forEach(function(serie){
			for (var i = 1; i < startAttributes; i++) {
				var values = serie[i].split(';');
				values.forEach(function (value){
					dataNt += getUri(serie[0]) + getUri(index[i]) + getUri(value.replace(" ", ""))+ ".\n";
				})

			}

			for (var i = startAttributes; i < serie.length; i++) {
				dataNt += getUri(serie[0]) + getUri(index[i]) + "\"" + serie[i] + "\"^^" + "<http://www.w3.org/2001/XMLSchema#integer> " + ". # xsd:integer\n";
			}

		})
		fs.writeFile("datav1.nt", dataNt, function(err){
			console.log(err);
		})
	})
})

function getUri(name){
	return "<http://www.ema.com/ontologies/series#" + name + "> ";
}