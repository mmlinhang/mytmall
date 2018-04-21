package mytmall.mapper;

import mytmall.pojo.Property;
import java.util.List;

public interface PropertyMapper
{
    List<Property> list(int id, int start, int count);
    int count(int id);
    void add(Property property);
    void delete(int id);
    void update(Property p);
    void deleteAll(int cid);
    Property get(int propertyId);
}
