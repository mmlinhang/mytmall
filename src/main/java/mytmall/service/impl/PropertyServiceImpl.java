package mytmall.service.impl;

import mytmall.mapper.PropertyMapper;
import mytmall.pojo.Property;
import mytmall.pojo.PropertyValue;
import mytmall.service.PropertyService;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PropertyServiceImpl implements PropertyService
{
    @Autowired
    private PropertyMapper propertyMapper;

    public List<Property> list(int id, int start, int count)
    {
        return propertyMapper.list(id, start, count);
    }

    public int count(int id)
    {
        return propertyMapper.count(id);
    }

    public void add(Property property)
    {
        propertyMapper.add(property);
    }

    public void delete(int id)
    {
        propertyMapper.delete(id);
    }

    public void update(Property p)
    {
        propertyMapper.update(p);
    }

    public void deleteAll(int cid)
    {
        propertyMapper.deleteAll(cid);
    }

    public Property get(int propertyId)
    {
        return propertyMapper.get(propertyId);
    }

    public void setPropertyForPropertyValue(PropertyValue pv)
    {
        Property property = propertyMapper.get(pv.getPropertyId());
        pv.setProperty(property);
    }

    public void setPropertyForPropertyValues(List<PropertyValue> pvs)
    {
        for(PropertyValue pv:pvs)
            setPropertyForPropertyValue(pv);
    }
}
