
package ceus.model.blockchain.address;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sequence",
    "witness",
    "prev_out",
    "script"
})
public class Input {

    @JsonProperty("sequence")
    private Integer sequence;
    @JsonProperty("witness")
    private String witness;
    @JsonProperty("prev_out")
    private PrevOut prevOut;
    @JsonProperty("script")
    private String script;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sequence")
    public Integer getSequence() {
        return sequence;
    }

    @JsonProperty("sequence")
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @JsonProperty("witness")
    public String getWitness() {
        return witness;
    }

    @JsonProperty("witness")
    public void setWitness(String witness) {
        this.witness = witness;
    }

    @JsonProperty("prev_out")
    public PrevOut getPrevOut() {
        return prevOut;
    }

    @JsonProperty("prev_out")
    public void setPrevOut(PrevOut prevOut) {
        this.prevOut = prevOut;
    }

    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    @JsonProperty("script")
    public void setScript(String script) {
        this.script = script;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
