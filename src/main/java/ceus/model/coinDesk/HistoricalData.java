package ceus.model.coinDesk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bpi",
"disclaimer",
"time"
})
public class HistoricalData {

@JsonProperty("bpi")
private BpiHistorical bpiHistorical;
@JsonProperty("disclaimer")
private String disclaimer;
@JsonProperty("time")
private Time time;

@JsonProperty("bpi")
public BpiHistorical getBpiHistorical() {
return bpiHistorical;
}

@JsonProperty("bpi")
public void setBpiHistorical(BpiHistorical bpiHistorical) {
this.bpiHistorical = bpiHistorical;
}

@JsonProperty("disclaimer")
public String getDisclaimer() {
return disclaimer;
}

@JsonProperty("disclaimer")
public void setDisclaimer(String disclaimer) {
this.disclaimer = disclaimer;
}

@JsonProperty("time")
public Time getTime() {
return time;
}

@JsonProperty("time")
public void setTime(Time time) {
this.time = time;
}

}