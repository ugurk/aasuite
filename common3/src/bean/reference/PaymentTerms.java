/*
 * Paymentmethod.java
 *
 * Created on Nov 23, 2007, 8:40:57 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.reference;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import template.Display;
import template.Displays;
import template.UITemplate;
import template.screen.TemplateDefault;

/**
 *
 * @author pogi
 */
@Entity
@Table(name = "PaymentTerms")
@UITemplate(template = TemplateDefault.class, gridCount = 4, columnSearch = {"type", "value"})
@Displays({
        @Display(name="type"),
        @Display(name="value")
})
public class PaymentTerms extends ReferenceType implements Serializable {
    @Id
    @Column(name = "type", nullable = false)
    public String type;
    @Column(name = "value")
    public String value;

    @Override
    public String popupSearch(String criteria) {
        return buildSearch(criteria, "type", "value");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
