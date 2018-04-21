package mytmall.util;

public class Page
{
    private int start;
    private int count;
    private int total;
    private String param="";
    private static final int initialCount = 5;

    public Page()
    { count = initialCount; }

    public void setStart(int start)
    {this.start = start;}

    public int getStart()
    {return start;}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage()
    {
        int totalPage = 0;
        if(total % count == 0)
            totalPage = total / count;
        else
            totalPage = total / count + 1;

        if(totalPage == 0)
            totalPage = 1;

        return totalPage;
    }

    public boolean isHasPrevious()
    {
        if(start == 0)
            return false;
        return true;
    }

    public boolean isHasNext()
    {
        if(getLast() == start)
            return false;
        return true;
    }

    public int getLast()
    {
        int totalPage = getTotalPage();

        int last = count*(totalPage-1);

        return last;
    }

    public void setParam(String param)
    {
        this.param = param;
    }
    public String getParam()
    {
        return param;
    }
}
