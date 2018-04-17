import java.io.*;

public class ProductFile {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();

        productManagement.setProductCode(12);
        productManagement.setProductName("bake");
        productManagement.setManufacturer("orio");
        productManagement.setPrice(3000);
        productManagement.setOtherDescriptions("ngon");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("product.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productManagement);

            objectOutputStream.close();
            fileOutputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("product.txt"));
            ProductManagement obj = (ProductManagement) inputStream.readObject();

            System.out.println("Code: " + obj.getProductCode());
            System.out.println("Name: " + obj.getProductName());
            System.out.println("Manufactuer: " + obj.getManufacturer());
            System.out.println("Price: " + obj.getPrice());
            System.out.println("Description: " + obj.getOtherDescriptions());

//            System.out.println("complete");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
