package OnlineTicketing.wishlist.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="wishlist_impl")
@Table(name="wishlist_impl")
public class WishlsitImpl extends WishlsitComponent {

	public WishlsitImpl(UUID id, String title) {
		this.id = id;
		this.title = title;
	}

	public WishlsitImpl(String title) {
		this.id =  id.randomUUID();;
		this.title = title;
	}

	public WishlsitImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistMap = new HashMap<String,Object>();
		wishlistMap.put("id",getId());
		wishlistMap.put("title",getTitle());

        return wishlistMap;
    }

}
