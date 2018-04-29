
package ceus.model.CoinDesk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "time",
    "disclaimer",
    "bpi"
})
public class CourrentData {

    @JsonProperty("time")
    private Time time;
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("bpi")
    private Bpi bpi;

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("bpi")
    public Bpi getBpi() {
        return bpi;
    }

    @JsonProperty("bpi")
    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }

}
