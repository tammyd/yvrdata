package ca.tammyd.data.yvr.db;


import ca.tammyd.data.yvr.core.CityHallCaseLocation;
import ca.tammyd.data.yvr.core.SqlQueryRecordResult;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;


import java.util.List;

@UseStringTemplate3StatementLocator
public abstract class YVRDataDAO<T1, T2> {

    public String tableName = "";

    public YVRDataDAO(String tableName) {
        this.tableName = tableName;
    }

    @SqlQuery("select count(*) from <table>")
    abstract int _getTotalRecordCount(@Define("table") String table);

    @SqlQuery("select * from <table> where id = :id")
    abstract T1 _findById(@Define("table") String table, @Bind("id") int id);

    @SqlQuery("select * from <table> LIMIT :offset,:count")
    abstract List<T1> _get(@Define("table") String table, @Bind("offset") int offset, @Bind("count") int count);

    @SqlQuery("select distinct(<field>) from <table>")
    abstract List<T2> _getDistinctStringFieldValue(@Define("table") String table, @Define("field") String field);

    //@SqlQuery("select count(id) as total, <fields> from <table> group by <fields> order by total desc;")

    public int getTotalRecordCount() {
        return _getTotalRecordCount(this.tableName);
    }

    public T1 findById(int id) {
        return _findById(this.tableName, id);
    }

    public List<T1> get(int offset, int count) {
        return _get(this.tableName, offset, count);
    }


}
