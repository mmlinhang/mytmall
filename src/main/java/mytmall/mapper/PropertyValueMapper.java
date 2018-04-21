package mytmall.mapper;

import mytmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueMapper
{
    PropertyValue getByProductIdAndPropertyId(int productId, int propertyId);
    PropertyValue getByPropertyValueId(int pvid);
    void update(PropertyValue pv);
    void add(PropertyValue pv);
    List<PropertyValue> getByProductId(int pid);
}
