package ca.tammyd.data.yvr;

import ca.tammyd.data.yvr.db.CityHallCaseLocationDAO;
import ca.tammyd.data.yvr.resources.CityHallResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class YVRDataApplication extends Application<YVRDataConfiguration> {
    public static void main(String[] args) throws Exception {
        new YVRDataApplication().run(args);
    }

    @Override
    public String getName() {
        return "yvrdata";
    }

    @Override
    public void initialize(Bootstrap<YVRDataConfiguration> bootstrap) {
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(YVRDataConfiguration configuration,
                    Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final CityHallCaseLocationDAO cityHallDAO = jdbi.onDemand(CityHallCaseLocationDAO.class);


        final CityHallResource resource = new CityHallResource(
                cityHallDAO
        );


        environment.jersey().register(resource);
    }

}