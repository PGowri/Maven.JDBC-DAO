package daos;

import models.Menu;

import java.util.List;

public class AppRunner {
    static int Id;

    public static void main(String[] args) {
     findAll();
     findById();



    }

    public static void findById() {
        DaoClass dao = new DaoClass();
        Menu output =  dao.findById(Id);
        System.out.println(output);
    }


    public static void findAll(){
        DaoClass dao = new DaoClass();
        List<Menu> output = dao.findAll();
        for(int i =0; i<output.size(); i ++){
            System.out.println(output.get(i));
        }
    }




//    public static void update(){
//        DaoClass dao = new DaoClass();
//
//    }

}