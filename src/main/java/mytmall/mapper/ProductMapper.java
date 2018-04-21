package mytmall.mapper;

import mytmall.pojo.Product;

import java.util.List;

public interface ProductMapper
{
    List<Product> list(int cid, int start, int count);
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    int total(int cid);
}
