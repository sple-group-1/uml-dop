package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CollectionResource {
    List<HashMap<String,Object>> saveCollection(VMJExchange vmjExchange);
    HashMap<String, Object> updateCollection(VMJExchange vmjExchange);
    HashMap<String, Object> getCollection(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCollection(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCollection(VMJExchange vmjExchange);
	HashMap<String, Object> createCollection(VMJExchange vmjExhange);
}
