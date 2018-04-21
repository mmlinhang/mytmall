package mytmall.pojo;

import java.util.List;

public class Category
{
    private int category_id;
    private String category_name;

    private List<Product> products;
    private List<List<Product>> productsByRows;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRows() {
        return productsByRows;
    }

    public void setProductsByRows(List<List<Product>> productsByRows) {
        this.productsByRows = productsByRows;
    }

    public void setCategoryId(int id)
    {
        this.category_id = id;
    }
    public int getCategoryId()
    {
        return category_id;
    }

    public void setCategoryName(String name)
    {
        this.category_name = name;
    }
    public String getCategoryName()
    {
        return category_name;
    }
}
