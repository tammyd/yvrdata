package ca.tammyd.data.yvr.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {

    @JsonProperty
    public int getCount() {
        return this.data.size();
    }

    @JsonProperty
    protected int page;

    @JsonProperty
    protected int totalCount;

    @JsonProperty
    protected List data;

    protected int pageLength;


    public Result(List data) {
        this.data = data;
    }

    public Result setRecords(List data) {
        this.data = data;

        return this;
    }

    public List getData() {
        return this.data;
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

    public Result setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        return this;
    }

    public int getPage() {
        return page;
    }

    public Result setPage(int page) {
        this.page = page;

        return this;
    }


    public Result setPageLength(int pageLength) {
        this.pageLength = pageLength;

        return this;
    }
}
