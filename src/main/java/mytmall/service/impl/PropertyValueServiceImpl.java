package mytmall.service.impl;

import mytmall.mapper.PropertyValueMapper;
import mytmall.pojo.Product;
import mytmall.pojo.Property;
import mytmall.pojo.PropertyValue;
import mytmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService
{
    @Autowired
    private PropertyValueMapper propertyValueMapper;

    public PropertyValue getByProductIdAndPropertyId(int productId, int propertyId)
    {
        return propertyValueMapper.getByProductIdAndPropertyId(productId, propertyId);
    }

    public PropertyValue getByPropertyValueId(int pvid)
    {
        return propertyValueMapper.getByPropertyValueId(pvid);
    }

    public void update(PropertyValue pv)
    {
        propertyValueMapper.update(pv);
    }

    public void add(PropertyValue pv)
    {
        propertyValueMapper.add(pv);
    }

    public List<PropertyValue> getByProductId(int pid) {
        return propertyValueMapper.getByProductId(pid);
    }

    public void addWithNewProperty(int propertyId, List<Product> ps)
    {
        PropertyValue pv = new PropertyValue();
        pv.setPropertyId(propertyId);

        for(Product p:ps)
        {
            pv.setProductId(p.getId());
            add(pv);
        }
    }

    public void addWithNewProduct(int productId, List<Property> ps)
    {
        PropertyValue pv = new PropertyValue();
        pv.setProductId(productId);

        for(Property p:ps)
        {
            pv.setPropertyId(p.getId());
            add(pv);
        }
    }
}
