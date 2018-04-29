package ceus.model.CoinDesk;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"tuple"})
public class BpiHistorical {
	
	@JsonProperty("tuple")
	private List<Tuple> valores;
	
	@JsonProperty("tuple")
	public List<Tuple> getTuples(){
		return this.valores;
	}
	
	public Map<LocalDate, Double> getValues() {
		Map<LocalDate, Double> res = new HashMap<>();

		for(Tuple t : getTuples()) {
			res.put(t.getFecha(), t.getValor());
		}
		
		return res;
	}

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
