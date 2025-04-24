package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.wishlist.Collection;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class Collection extends Collection{
	
	private Collection collectionServiceImpl = new Collection();

	// @Restriced(permission = "")
    @Route(url="call/wishlist")
    public HashMap<String,Object> createcollection(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Collection result = collectionServiceImpl.createCollection(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/wishlist/update")
    public HashMap<String, Object> updateCollection(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return collectionServiceImpl.updateCollection(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlist/detail")
    public HashMap<String, Object> getCollection(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return collectionServiceImpl.getCollection(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlist/list")
    public List<HashMap<String,Object>> getAllCollection(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return collectionServiceImpl.getAllCollection(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/wishlist/delete")
    public List<HashMap<String,Object>> deleteCollection(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return collectionServiceImpl.deleteCollection(requestBody);
	}

}
