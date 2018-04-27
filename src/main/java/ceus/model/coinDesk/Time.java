
package ceus.model.coinDesk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "updated",
    "updatedISO",
    "updateduk"
})
public class Time {

    @JsonProperty("updated")
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    @JsonProperty("updateduk")
    private String updateduk;

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("updatedISO")
    public String getUpdatedISO() {
        return updatedISO;
    }

    @JsonProperty("updatedISO")
    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    @JsonProperty("updateduk")
    public String getUpdateduk() {
        return updateduk;
    }

    @JsonProperty("updateduk")
    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }

}
