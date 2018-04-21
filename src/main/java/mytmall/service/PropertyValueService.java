package mytmall.service;

import mytmall.pojo.Product;
import mytmall.pojo.Property;
import mytmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService
{
    PropertyValue getByProductIdAndPropertyId(int productId, int propertyId);
    PropertyValue getByPropertyValueId(int pvid);
    void update(PropertyValue pv);
    void add(PropertyValue pv);
    List<PropertyValue> getByProductId(int pid);
    void addWithNewProperty(int propertyId, List<Product> ps);
    void addWithNewProduct(int productId, List<Property> ps);
}
