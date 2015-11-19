package ca.tammyd.data.yvr.db;

import ca.tammyd.data.yvr.core.CityHallCaseLocation;
import ca.tammyd.data.yvr.core.CityHallCaseLocationMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CityHallCaseLocationMapper.class)
public interface CityHallCaseLocationDAO {

    @SqlQuery("select count(*) from case_location_details")
    int getTotalRecordCount();

    @SqlQuery("select * from case_location_details where id = :id")
    CityHallCaseLocation findById(@Bind("id") int id);

    @SqlQuery("select * from case_location_details LIMIT :offset,:count")
    List<CityHallCaseLocation> get(@Bind("offset") int offset, @Bind("count") int count);
}
