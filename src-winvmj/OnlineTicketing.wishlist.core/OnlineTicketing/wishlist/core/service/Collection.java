package OnlineTicketing.wishlist.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.wishlist.Collection;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class Collection extends Collection{

    public List<HashMap<String,Object>> saveCollection(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Collection collection = createCollection(vmjExchange);
		collectionRepository.saveObject(collection);
		return getAllCollection(vmjExchange);
	}

    public Collection createCollection(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		Collection Collection = CollectionFactory.createCollection(
			"OnlineTicketing.wishlist.core.Collection",
		);
		Repository.saveObject(collection);
		return collection;
	}

    public Collection createCollection(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		Collection collection = CollectionFactory.createCollection("OnlineTicketing.wishlist.core.Collection", );
		return collection;
	}

    public HashMap<String, Object> updateCollection(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Collection collection = Repository.getObject(id);
		
		
		Repository.updateObject(collection);
		
		//to do: fix association attributes
		
		return collection.toHashMap();
		
	}

    public HashMap<String, Object> getCollection(Map<String, Object> requestBody){
		List<HashMap<String, Object>> collectionList = getAllCollection("collection_impl");
		for (HashMap<String, Object> collection : collectionList){
			int record_id = ((Double) collection.get("record_id")).intValue();
			if (record_id == id){
				return collection;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCollectionById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		Collection collection = collectionRepository.getObject(id);
		return collection.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCollection(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Collection> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Collection> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCollection(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCollection(requestBody);
	}

}
