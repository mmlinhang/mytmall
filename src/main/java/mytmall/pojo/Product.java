package mytmall.pojo;

import java.util.Date;
import java.util.List;

public class Product
{
    private int id;
    private String name;
    private String subTitle;
    private int cid;
    private float originPrice;
    private float discountPrice;
    private int reviewNum;
    private int vol;
    private int stock;
    private Date createDate;
    private Category category;
    private int firstPid = -1;
    private List<Integer> singelPids;
    private List<Integer> detailPids;

    public List<Integer> getSingelPids() {
        return singelPids;
    }

    public void setSingelPids(List<Integer> singelPids) {
        this.singelPids = singelPids;
    }

    public List<Integer> getDetailPids() {
        return detailPids;
    }

    public void setDetailPids(List<Integer> detailPids) {
        this.detailPids = detailPids;
    }

    public int getFirstPid() {
        return firstPid;
    }

    public void setFirstPid(int firstPid) {
        this.firstPid = firstPid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public float getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(float originPrice) {
        this.originPrice = originPrice;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
