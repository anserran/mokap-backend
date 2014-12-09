package es.eucm.mokap.backend.model.response;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Class that represents the response to a search request. It should contain all the necessary data to access the results,
 * resume the search with a cursor and know if the request was successful.
 */
public class SearchResponse extends Response {
	private long total;
	
	private String message;
	private String searchCursor;
	private String searchString;
	private List<Map<String,Object>> results = new LinkedList<Map<String,Object>>();
	
	public void addResult(Map<String, Object> ent){
		this.results.add(ent);
	}
	
	public int getCount() {
		return results.size();
	}
	public List<Map<String, Object>> getResults() {
		return results;
	}
	public void setResults(List<Map<String, Object>> results) {
		this.results = results;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long l) {
		this.total = l;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSearchCursor() {
		return searchCursor;
	}

	public void setSearchCursor(String string) {
		this.searchCursor = string;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
