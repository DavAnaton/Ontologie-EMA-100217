var app = require('express')(),
	ejs = require('ejs');

app.get('/', function(req, res){
	res.render('index.ejs');
})

app.listen(8080);