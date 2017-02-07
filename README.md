# Ontologie-EMA-100217
## TV-Show Seeker

[![LogoTVShow](https://github.com/DavAnaton/Ontologie-EMA-100217/raw/master/Docs/logo.png)]()

TV-Show Seeker is an application that uses Web Ontology Language to find quickly and efficiently throught a lot of TV-Shows the one that matches your requirements.

For now, you can:
- Change the database you want to use by changing a simple CSV file
- Run the default Java code and see all the TV shows
- Write your own code to find specific TV-shows


### Installation

TV-show Seeker is running using Java.

Some preprocessing might be needed to change the Database. You need to do this with [Node.js](https://nodejs.org/).

To see the default query, just run the project and admire the result:

```sh
SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#Serie> }
----------------------------------------------------------
| Serie                                                  |
==========================================================
| <http://www.ema.com/ontologies/series#Sherlock>        |
| <http://www.ema.com/ontologies/series#Pride-Prejudice> |
| <http://www.ema.com/ontologies/series#Earl>            |
| <http://www.ema.com/ontologies/series#NewGirl>         |
| <http://www.ema.com/ontologies/series#Narcos>          |
| <http://www.ema.com/ontologies/series#Pokemon>         |
| <http://www.ema.com/ontologies/series#Suits>           |
| <http://www.ema.com/ontologies/series#BreakingBad>     |
| <http://www.ema.com/ontologies/series#Stargate>        |
| <http://www.ema.com/ontologies/series#Glee>            |
| <http://www.ema.com/ontologies/series#Kaamelott>       |
----------------------------------------------------------
```

### Usage
#### Create your own queries
If you want to create your own queries, you can see how it's working in the comments of the ```Main.class```:

```java
Search queryParams = new Search();
queryParams.addActor("BeachbodyCunningscratch");
queryParams.addNationality("Grande-Bretagne");
queryParams.setAnneeDebut("2012");

// This line generates the query that will only return Sherlock 
String query = queryParams.search();
```

#### Change the database
In order to use a fully functional database, you have to edit ```/Series/ressources/data.csv``` . Once this is done, you have to export this csv into a ```datav1.nt```. 
To do that, use the Node script in the same folder. 
Just run
```sh
$ npm install
$ node index.js
```
And now, **You're ready to go!!**
### Development

Want to contribute?
We still have much to do. Here's a small list:
#### Todos

- Create a GUI to allow on-the-fly creation of queries. (It means users will be able to search for TV-Shows just using dropdowns and text fields)
- Fix a bugs

#### Bugs

1. Running the default query brings up **2 unwanted results**:
*Query*: `SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#Serie> }`
*Result*:
**_:b0**
**_:b1**

2. Inferred results don't seem to be working at all. For example, those 2 queries should output the same result:

*Query*: `SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#Serie> . ?Serie <http://www.ema.com/ontologies/series#isAiredOn> <http://www.ema.com/ontologies/series#Web> }`
*Result*: **2 results, 2 expected**

*Query*: `SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#Serie-Web> }`
*Result*: **0 result, 2 expected**

And this result set should not be empty:
*Query*: `SELECT ?Serie WHERE { ?Serie a <http://www.ema.com/ontologies/series#Mini-Serie> }`
*Result*: **0 result, 1 expected**
