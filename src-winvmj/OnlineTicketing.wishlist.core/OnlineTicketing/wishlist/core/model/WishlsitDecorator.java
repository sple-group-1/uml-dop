package OnlineTicketing.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlsitDecorator extends WishlsitComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlsitComponent record;

	public WishlsitDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public WishlsitDecorator (WishlsitComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public WishlsitDecorator (UUID id, WishlsitComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public WishlsitDecorator (WishlsitComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public WishlsitDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
