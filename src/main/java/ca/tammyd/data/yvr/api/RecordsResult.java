package ca.tammyd.data.yvr.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecordsResult extends ListResult {

    @JsonProperty
    protected int page;

    @JsonProperty
    protected int totalCount;

    @JsonProperty
    protected List data;

    protected int pageLength;

    public RecordsResult(List data) {
        super(data);
    }

    public int getTotalCount() {
        return totalCount;
    }

    @JsonProperty
    public int getTotalPages() {
        if (this.pageLength < 1) {
            return 1;
        } else {
            return (int) Math.ceil((double) this.getTotalCount() / (double) this.pageLength);
        }
    }

    public RecordsResult setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        return this;
    }

    public int getPage() {
        return page;
    }

    public RecordsResult setPage(int page) {
        this.page = page;

        return this;
    }


    public RecordsResult setPageLength(int pageLength) {
        this.pageLength = pageLength;

        return this;
    }
}
