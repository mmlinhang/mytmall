package mytmall.controller;


import mytmall.pojo.Picture;
import mytmall.service.PictureService;
import mytmall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class PictureController
{
    @Autowired
    private PictureService pictureService;

    @RequestMapping("admin_picture_add")
    public String add(Picture picture, MultipartFile image, HttpServletRequest request)
    {
        pictureService.add(picture);

        //存储图片
        File parentDir = getParentDir(picture.getType(), request);
        ImageUtil.storeImage(picture.getId(), image, parentDir);

        return "redirect:admin_product_imagePage?pid="+picture.getPid();
    }

    @RequestMapping("admin_picture_delete")
    public String delete(int id, HttpServletRequest request)
    {
        //删除图片
        Picture picture = pictureService.get(id);
        File parentDir = getParentDir(picture.getType(), request);
        File file = new File(parentDir, picture.getId()+".jpg");
        file.delete();

        pictureService.delete(id);

        return "redirect:admin_product_imagePage?pid="+picture.getPid();
    }

    private File getParentDir(int pictureType, HttpServletRequest request)
    {
        File parentDir;
        String parentPath = request.getServletContext().getRealPath("img");
        if(pictureType == 1)
            parentDir = new File(parentPath+"/productSingle");
        else
            parentDir = new File(parentPath+"/productDetail");

        return parentDir;
    }

}
