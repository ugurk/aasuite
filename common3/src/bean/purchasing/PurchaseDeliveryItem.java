/*
 * PurchaseOrderItem.java
 *
 * Created on Nov 29, 2007, 6:17:50 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.purchasing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import service.util.AbstractIBean;
import template.Display;
import template.Displays;
import template.UITemplate;
import template.screen.TemplateDefault;
import bean.embed.AbstractSalesOrPurchaseItem;
import bean.inventory.Product;

/**
 *
 * @author pogi
 */
@Entity
@Table(name = "PurchaseOrderItem")
@UITemplate(template = TemplateDefault.class, gridCount = 4, columnSearch = {"seq", "product", "totalAmount"})
@Displays({
        @Display(name="seq"),
        @Display(name="purchaseOrderId"),
        @Display(name="product", type = "PopSearch", linktoBean = Product.class),
        @Display(name="amountPerUnit"),
        @Display(name="numberOfItem"),
        @Display(name="totalAmount"),
        @Display(name="lastReceivedDate"),
        @Display(name="receivedCount"),
        @Display(name="totalReceivedCount"),
        @Display(name="remarks")
})
public class PurchaseDeliveryItem extends AbstractIBean implements Serializable {
    @Id
    @Column(name = "seq", nullable = false)
    public Integer seq;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="purchaseDeliveryId")
    public PurchaseDelivery purchaseDelivery;

    @Embedded
    public AbstractSalesOrPurchaseItem item;

    @Override
    public String popupSearch(String criteria) {
        return buildSearch(criteria);
    }

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public AbstractSalesOrPurchaseItem getItem() {
		return item;
	}

	public void setItem(AbstractSalesOrPurchaseItem item) {
		this.item = item;
	}

	public PurchaseDelivery getPurchaseDelivery() {
		return purchaseDelivery;
	}

	public void setPurchaseDelivery(PurchaseDelivery purchaseDelivery) {
		this.purchaseDelivery = purchaseDelivery;
	}

}
