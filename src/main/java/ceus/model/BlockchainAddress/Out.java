
package ceus.model.BlockchainAddress;

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
    "spent",
    "tx_index",
    "type",
    "addr",
    "value",
    "n",
    "script"
})
public class Out {

    @JsonProperty("spent")
    private Boolean spent;
    @JsonProperty("tx_index")
    private Integer txIndex;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("addr")
    private String addr;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("n")
    private Integer n;
    @JsonProperty("script")
    private String script;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("spent")
    public Boolean getSpent() {
        return spent;
    }

    @JsonProperty("spent")
    public void setSpent(Boolean spent) {
        this.spent = spent;
    }

    @JsonProperty("tx_index")
    public Integer getTxIndex() {
        return txIndex;
    }

    @JsonProperty("tx_index")
    public void setTxIndex(Integer txIndex) {
        this.txIndex = txIndex;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @JsonProperty("addr")
    public String getAddr() {
        return addr;
    }

    @JsonProperty("addr")
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("n")
    public Integer getN() {
        return n;
    }

    @JsonProperty("n")
    public void setN(Integer n) {
        this.n = n;
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
