package OnlineTicketing.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="customer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CustomerComponent implements Customer{
	@Id
	public UUID id; 
	public String email;
	public String name;
	protected String objectName = CustomerComponent.class.getName();

	public CustomerComponent() {

	} 

	public CustomerComponent(
        UUID id, String email, String name
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract String getEmail();
	public abstract void setEmail(String email);
	
	public abstract String getName();
	public abstract void setName(String name);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }
	
}
