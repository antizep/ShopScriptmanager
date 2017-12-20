package spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "price", schema = "public", catalog = "postgres")
public class EntityPrice implements Serializable{
    private EntityProvider providerByProvider;
    private EntityProduct productByProduct;

    @ManyToOne
    @JoinColumn(name = "provider", referencedColumnName = "id", nullable = false)
    public EntityProvider getProviderByProvider() {
        return providerByProvider;
    }

    public void setProviderByProvider(EntityProvider providerByProvider) {
        this.providerByProvider = providerByProvider;
    }
@Id
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id", nullable = false)
    public EntityProduct getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(EntityProduct productByProduct) {
        this.productByProduct = productByProduct;
    }
}
