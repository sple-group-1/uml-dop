package OnlineTicketing.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlsitComponent implements Wishlist{
	@Id
	public UUID id; 
	public String title;
	protected String objectName = WishlsitComponent.class.getName();

	public WishlsitComponent() {

	} 

	public WishlsitComponent(
        UUID id, String title
    ) {
        this.id = id;
        this.title = title;
    }

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " title='" + getTitle() + "'" +
            "}";
    }
	
}
