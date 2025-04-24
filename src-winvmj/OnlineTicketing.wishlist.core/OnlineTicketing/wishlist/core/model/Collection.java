package OnlineTicketing.wishlist.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Collection {
	public UUID getId();
	public void setId(UUID id);
	public String getTitle();
	public void setTitle(String title);
	HashMap<String, Object> toHashMap();
}
