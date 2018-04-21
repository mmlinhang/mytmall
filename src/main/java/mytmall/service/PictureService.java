package mytmall.service;

import mytmall.pojo.Picture;

import java.util.List;

public interface PictureService
{
    int getFirstPid(int pid);
    List<Integer> getSinglePids(int pid);
    List<Integer> getDetailPids(int pid);
    void add(Picture picture);
    void delete(int id);
    Picture get(int id);
}
