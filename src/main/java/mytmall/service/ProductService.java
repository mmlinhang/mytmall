package mytmall.service;

import mytmall.pojo.Category;
import mytmall.pojo.OrderItem;
import mytmall.pojo.Product;
import mytmall.util.Page;

import java.util.List;

public interface ProductService
{
    List<Product> list(int cid, int start, int count);
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    int total(int cid);

    void setFirstPidForProduct(Product p);
    void setFirstPidForProducts(List<Product> ps);
    void setProductsForCategorys(List<Category> cs);
    void setProductsByRowsForCategorys(List<Category> cs);
    void setProductForOrderItem(OrderItem oi);
    void setProductForOrderItems(List<OrderItem> ois);
}
