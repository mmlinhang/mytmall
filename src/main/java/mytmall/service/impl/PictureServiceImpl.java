package mytmall.service.impl;

import mytmall.mapper.PictureMapper;
import mytmall.pojo.Picture;
import mytmall.pojo.Product;
import mytmall.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService
{
    @Autowired
    private PictureMapper pictureMapper;

    public int getFirstPid(int pid)
    {
        List<Integer> pids = pictureMapper.getSinglePids(pid);
        if(pids.size() == 0)
            return -1;
        return pids.get(0);
    }

    public List<Integer> getSinglePids(int pid)
    {
        return pictureMapper.getSinglePids(pid);
    }

    public List<Integer> getDetailPids(int pid)
    {
        return pictureMapper.getDetailPids(pid);
    }

    public void add(Picture picture)
    {
        pictureMapper.add(picture);
    }

    public void delete(int id)
    {
        pictureMapper.delete(id);
    }

    public Picture get(int id)
    {
        return pictureMapper.get(id);
    }
}
