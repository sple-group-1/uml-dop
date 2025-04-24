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
import OnlineTicketing.wishlist.WishlsitFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlsitServiceImpl extends WishlsitServiceComponent{

    public List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Wishlist wishlist = createWishlist(vmjExchange);
		wishlistRepository.saveObject(wishlist);
		return getAllWishlist(vmjExchange);
	}

    public Wishlist createWishlist(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		
		//to do: fix association attributes
		Wishlist Wishlist = WishlistFactory.createWishlist(
			"OnlineTicketing.wishlist.core.WishlsitImpl",
		id
		, title
		);
		Repository.saveObject(wishlist);
		return wishlist;
	}

    public Wishlist createWishlist(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		
		//to do: fix association attributes
		
		Wishlist wishlist = WishlistFactory.createWishlist("OnlineTicketing.wishlist.core.WishlsitImpl", title);
		return wishlist;
	}

    public HashMap<String, Object> updateWishlist(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Wishlist wishlist = Repository.getObject(id);
		
		wishlist.setTitle((String) requestBody.get("title"));
		
		Repository.updateObject(wishlist);
		
		//to do: fix association attributes
		
		return wishlist.toHashMap();
		
	}

    public HashMap<String, Object> getWishlist(Map<String, Object> requestBody){
		List<HashMap<String, Object>> wishlistList = getAllWishlist("wishlist_impl");
		for (HashMap<String, Object> wishlist : wishlistList){
			int record_id = ((Double) wishlist.get("record_id")).intValue();
			if (record_id == id){
				return wishlist;
			}
		}
		return null;
	}

	public HashMap<String, Object> getWishlistById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Wishlist wishlist = wishlistRepository.getObject(id);
		return wishlist.toHashMap();
	}

    public List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Wishlist> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllWishlist(requestBody);
	}

}
