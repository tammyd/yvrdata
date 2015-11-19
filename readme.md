Surfacing some of the data from [Vancouver's Open Data Catalogue](http://vancouver.ca/your-government/open-data-catalogue.aspx)

This is a Java Dropwizard app. Use Java 1.8.

To run:

```
$ ## you'll need a database populated with data. TODO - document this
$ cp config.yml.dist config.
$ ## fill out the todo's in the config.yml to match your DB
$ mvn package
$ java -jar target/yvr_data-*.jar server config.yml

```