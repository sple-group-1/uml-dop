package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlsitResourceComponent implements WishlistResource{
	
	public WishlsitResourceComponent() { }
 
    public abstract Wishlist createWishlist(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateWishlist(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlist(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange);

}
