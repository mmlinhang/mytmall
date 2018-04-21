package mytmall.mapper;

import mytmall.pojo.Picture;

import java.util.List;

public interface PictureMapper
{
    List<Integer> getSinglePids(int productId);
    List<Integer> getDetailPids(int productId);
    void add(Picture picture);
    void delete(int id);
    Picture get(int id);
}
