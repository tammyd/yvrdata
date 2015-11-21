package ca.tammyd.data.yvr.db;

import ca.tammyd.data.yvr.core.CityHallCaseLocation;
import ca.tammyd.data.yvr.core.CityHallCaseLocationMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import java.util.List;

@UseStringTemplate3StatementLocator
@RegisterMapper(CityHallCaseLocationMapper.class)
public abstract class CityHallCaseLocationDAO extends YVRDataDAO<CityHallCaseLocation, String> {

    public CityHallCaseLocationDAO() {
        super("case_location_details");
    }

    public List<String> getDepartments() {
        return _getDistinctStringFieldValue("case_location_details", "Department");
    }

    public List<String> getDivisions() {
        return _getDistinctStringFieldValue("case_location_details", "Division");
    }

    public List<String> getCaseTypes() {
        return _getDistinctStringFieldValue("case_location_details", "Case_Type");
    }

}
