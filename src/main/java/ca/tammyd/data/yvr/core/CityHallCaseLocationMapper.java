package ca.tammyd.data.yvr.core;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.Timestamp;

import org.skife.jdbi.v2.StatementContext;

import java.sql.SQLException;

public class CityHallCaseLocationMapper implements ResultSetMapper<CityHallCaseLocation> {
    @Override
    public CityHallCaseLocation map(int index, ResultSet r, StatementContext statementContext) throws SQLException {

        String block = r.getString("Hundred_Block");
        int hundredBlock;
        if (block.equals("Intersection")) {
            hundredBlock = -1;
        } else {
            hundredBlock = Integer.parseInt(block.replaceAll("#", "0"));
        }

        return new CityHallCaseLocation(r.getInt("id"), r.getInt("year"), r.getInt("Month"), r.getInt("Day"),
                r.getInt("Hour"), r.getInt("Minute"), r.getString("Department"), r.getString("Division"),
                r.getString("Case_Type"), hundredBlock, r.getString("Street_Name"), r.getString("Local_Area"));
    }
}
