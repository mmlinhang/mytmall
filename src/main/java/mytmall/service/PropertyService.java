package mytmall.service;

import mytmall.pojo.Property;
import mytmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyService
{
    List<Property> list(int id, int start, int count);
    int count(int id);
    void add(Property property);
    void delete(int id);
    void update(Property p);
    void deleteAll(int cid);
    Property get(int propertyId);
    void setPropertyForPropertyValue(PropertyValue pv);
    void setPropertyForPropertyValues(List<PropertyValue> pvs);
}
