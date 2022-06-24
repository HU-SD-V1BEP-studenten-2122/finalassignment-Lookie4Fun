package nl.hu.bep.setup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BattlesnakeRequest {
    public int turn;
    public Map<String, Object> you;

}
