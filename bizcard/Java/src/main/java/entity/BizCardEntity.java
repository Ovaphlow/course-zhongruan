package entity;

public class BizCardEntity {
  private int id;
  private String name;
  private String company;
  private String title;
  private String address;
  private String im;
  private String remark;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return this.company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIm() {
    return this.im;
  }

  public void setIm(String im) {
    this.im = im;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String toString() {
    return String.format("BizCard[%s, %s, %s, %s, %s, %s, %s]",
        id, name, company, title, address, im, remark);
  }
}