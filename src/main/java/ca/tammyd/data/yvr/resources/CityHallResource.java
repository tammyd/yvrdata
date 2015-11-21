package ca.tammyd.data.yvr.resources;

import ca.tammyd.data.yvr.api.ListResult;
import ca.tammyd.data.yvr.api.RecordsResult;
import ca.tammyd.data.yvr.core.CityHallCaseLocation;
import ca.tammyd.data.yvr.db.CityHallCaseLocationDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/yvr/cityhall")
@Produces(MediaType.APPLICATION_JSON)

public class CityHallResource {

    final static int PAGE_LENGTH = 25;
    static int totalRecords;

    protected CityHallCaseLocationDAO cityHallDAO;

    public CityHallResource(CityHallCaseLocationDAO cityHallDAO) {
        this.cityHallDAO = cityHallDAO;
        this.totalRecords = this.cityHallDAO.getTotalRecordCount();
    }

    protected RecordsResult buildResult(List data, int page) {
        return new RecordsResult(data).setPageLength(this.PAGE_LENGTH)
                .setTotalCount(this.totalRecords)
                .setPage(page);
    }

    @GET
    public RecordsResult get(@QueryParam("page") int page) {
        if (page < 1) { page = 1; }
        int offset = (page - 1) * this.PAGE_LENGTH;
        ArrayList<CityHallCaseLocation> data =  (ArrayList) this.cityHallDAO.get(offset, this.PAGE_LENGTH);

        return this.buildResult(data, page);

    }

    @GET
    @Path("/{id}")
    public RecordsResult findById(@PathParam("id") int id) {

        CityHallCaseLocation record = this.cityHallDAO.findById(id);
        ArrayList<CityHallCaseLocation> data = new ArrayList<>();
        data.add(record);

        return this.buildResult(data, 1).setTotalCount(1);
    }

    @GET
    @Path("departments")
    public ListResult getDepartments() {
        return new ListResult(this.cityHallDAO.getDepartments());
    }

    @GET
    @Path("divisions")
    public ListResult getDivisions() {
        return new ListResult(this.cityHallDAO.getDivisions());
    }


    @GET
    @Path("case_types")
    public ListResult getCaseTypes() {
        return new ListResult(this.cityHallDAO.getCaseTypes());
    }
}
