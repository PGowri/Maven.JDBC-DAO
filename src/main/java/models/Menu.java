package models;

public class Menu implements DtoInterface{
    private Integer Id;
    private String Chef;
    private String D_Name;
    private String D_Ingredients;
    private Integer Price;
    private String Location;

    public Menu(Integer id, String chef, String d_Name, String d_Ingredients, Integer price, String location) {
        Id = id;
        Chef = chef;
        D_Name = d_Name;
        D_Ingredients = d_Ingredients;
        Price = price;
        Location = location;
    }

    public Menu() {
    }

    public Menu(String chef, String d_Name, String d_Ingredients, Integer price, String location) {
        Chef = chef;
        D_Name = d_Name;
        D_Ingredients = d_Ingredients;
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

    public String getD_Ingredients() {
        return D_Ingredients;
    }

    public void setD_Ingredients(String d_Ingredients) {
        D_Ingredients = d_Ingredients;
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

}
