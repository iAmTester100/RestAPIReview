package test;

public class GetUsers {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private GetData data;
    private GetSupport support;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public GetData getData() {
        return data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(GetData data) {
        this.data = data;
    }

    public void setSupport(GetSupport support) {
        this.support = support;
    }

    public GetSupport getSupport() {
        return support;
    }
}
