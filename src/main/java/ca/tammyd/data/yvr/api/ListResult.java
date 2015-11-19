package ca.tammyd.data.yvr.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListResult {

    @JsonProperty
    protected List data;

    public ListResult(List data) {
        this.data = data;
    }

    @JsonProperty
    public int getCount() {
        return this.data.size();
    }

    public ListResult() {}

    public ListResult setRecords(List data) {
        this.data = data;

        return this;
    }

    public List getData() {
        return this.data;
    }


}
