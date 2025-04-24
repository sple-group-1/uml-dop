package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CollectionService {
	Collection createCollection(Map<String, Object> requestBody);
	Collection createCollection(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getCollection(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveCollection(Map<String, Object> requestBody);
    HashMap<String, Object> updateCollection(Map<String, Object> requestBody);
    HashMap<String, Object> getCollectionById(int id);
    List<HashMap<String,Object>> getAllCollection(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteCollection(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
