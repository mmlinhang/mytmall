package mytmall.service.impl;

import mytmall.mapper.ReviewMapper;
import mytmall.pojo.Review;
import mytmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService
{
    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> getReviewsForProduct(int pid)
    {
        return reviewMapper.getReviewsForProduct(pid);
    }
}
