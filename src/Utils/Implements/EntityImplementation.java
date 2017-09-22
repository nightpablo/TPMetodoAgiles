package Utils.Implements;

import org.json.JSONObject;

public interface EntityImplementation {
	
	public void toEntity(JSONObject object);
	
	public JSONObject toJSON();
	
	@Override
	public String toString();
}
