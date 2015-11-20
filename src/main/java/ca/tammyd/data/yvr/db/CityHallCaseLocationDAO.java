package ca.tammyd.data.yvr.db;

import ca.tammyd.data.yvr.core.CityHallCaseLocation;
import ca.tammyd.data.yvr.core.CityHallCaseLocationMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import java.util.List;

@UseStringTemplate3StatementLocator
@RegisterMapper(CityHallCaseLocationMapper.class)
public abstract class CityHallCaseLocationDAO extends YVRDataDAO {

    public CityHallCaseLocationDAO() {
        super("case_location_details");
    }

    @SqlQuery("select distinct(Department) from case_location_details")
    public abstract List<String> getDepartments();

    @SqlQuery("select distinct(Division) from case_location_details")
    public abstract List<String> getDivisions();

    @SqlQuery("select distinct(Case_Type) from case_location_details")
    public abstract List<String> getCaseTypes();
}
