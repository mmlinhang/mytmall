package mytmall.service.impl;

import mytmall.mapper.PictureMapper;
import mytmall.mapper.ProductMapper;
import mytmall.pojo.Category;
import mytmall.pojo.OrderItem;
import mytmall.pojo.Product;
import mytmall.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PictureMapper pictureMapper;

    public List<Product> list(int cid, int start, int count)
    {
        return productMapper.list(cid, start, count);
    }

    public void add(Product p)
    {
        productMapper.add(p);
    }

    public void delete(int id)
    {
        productMapper.delete(id);
    }

    public void update(Product p)
    {
       productMapper.update(p);
    }

    public Product get(int id)
    {
        return productMapper.get(id);
    }

    public int total(int cid)
    {
        return productMapper.total(cid);
    }

    @Override
    public void setFirstPidForProduct(Product p)
    {
        int pid = p.getId();
        List<Integer> pids = pictureMapper.getSinglePids(pid);
        int firstPid;
        if(pids.size() != 0)
            firstPid = pictureMapper.getSinglePids(pid).get(0);
        else
            firstPid = -1;

        p.setFirstPid(firstPid);
    }

    public void setFirstPidForProducts(List<Product> ps)
    {
        for(Product p:ps)
        {
            setFirstPidForProduct(p);
        }
    }

    public void setProductsForCategorys(List<Category> cs)
    {
        for(Category c:cs)
        {
            int cid = c.getCategoryId();
            List<Product> ps = productMapper.list(cid, 0, productMapper.total(cid));
            c.setProducts(ps);
        }
    }

    public void setProductsByRowsForCategorys(List<Category> cs)
    {
        final int productNumPerRow = 8;
        List<List<Product>> psByRows;
        for(Category c:cs)
        {
            List<Product> allPs = c.getProducts();
            psByRows = new ArrayList<List<Product>>();
            int yu = c.getProducts().size() % productNumPerRow;
            int chu = c.getProducts().size() / productNumPerRow;
            int rowNum = (yu == 0 ? chu : chu + 1);
            List<Product> row;
            int index = 0;
            for(int i = 0; i < rowNum; i++)
            {
                row = new ArrayList<>();
                for(int j = 0; j < productNumPerRow; j++)
                {
                    row.add(allPs.get(index));
                    index++;
                    if(index == allPs.size())
                        break;
                }
                psByRows.add(row);
            }
            c.setProductsByRows(psByRows);
        }
    }

    public void setProductForOrderItem(OrderItem oi)
    {
        Product p = productMapper.get(oi.getProductId());
        oi.setProduct(p);
    }

    public void setProductForOrderItems(List<OrderItem> ois) {
        for(OrderItem oi:ois)
            setProductForOrderItem(oi);
    }
}
