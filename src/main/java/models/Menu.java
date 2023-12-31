package models;

public class Menu implements DtoInterface{
    private Integer Id;
    private String Chef;
    private String D_Name;
    private String D_Ingredient;
    private Integer Price;
    private String Location;

    public Menu(Integer id, String chef, String d_Name, String d_Ingredient, Integer price, String location) {
        Id = id;
        Chef = chef;
        D_Name = d_Name;
        D_Ingredient = d_Ingredient;
        Price = price;
        Location = location;
    }

    public Menu() {
    }

    public Menu(String chef, String d_Name, String d_Ingredient, Integer price, String location) {
        Chef = chef;
        D_Name = d_Name;
        D_Ingredient = d_Ingredient;
        Price = price;
        Location = location;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getChef() {
        return Chef;
    }

    public void setChef(String chef) {
        Chef = chef;
    }

    public String getD_Name() {
        return D_Name;
    }

    public void setD_Name(String d_Name) {
        D_Name = d_Name;
    }

    public String getD_Ingredient() {
        return D_Ingredient;
    }

    public void setD_Ingredient(String d_Ingredient) {
        D_Ingredient = d_Ingredient;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Id=" + Id +
                ", Chef='" + Chef + '\'' +
                ", D_Name='" + D_Name + '\'' +
                ", D_Ingredient='" + D_Ingredient + '\'' +
                ", Price=" + Price +
                ", Location='" + Location + '\'' +
                '}';
    }
}
