package mytmall.mapper;

import java.util.List;
import mytmall.pojo.Category;
import mytmall.util.Page;

public interface CategoryMapper
{
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
    Category find(int id);
    void update(Category c);
}
