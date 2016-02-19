import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        Product producto = null;
        boolean repetido = false;
        int index = 0;
        while (!repetido && index < stock.size()){
            producto = stock.get(index);
            if (producto.getID() == item.getID()){
                repetido = true;
                System.out.println("Ese ID ya esta en Stock!");
            }
            index++;
        }
        if (repetido == false){
            stock.add(item);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if (producto != null){
            producto.increaseQuantity(amount);
        }
        else{
            System.out.println("No se ha encontrado ningun producto con el ID: " + id);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        boolean encontrado = false;
        int index = 0;
        Product producto = null;
        while (encontrado == false && index < stock.size()){
            if (id < 0 && id > stock.size()){
                encontrado = true;
            }
            else{
                producto = stock.get(index);
            }

            if (producto != null && producto.getID() == id){    
                producto = stock.get(index);
                encontrado = true;
            }
            index++;
        }
        return producto;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cantidad = 0;
        if (findProduct(id) != null){
            cantidad = findProduct(id).getQuantity();
        }
        return cantidad;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for ( Product producto: stock)
        {
            System.out.println(producto);
        }
    }

    /**
     * Print details of all the products under a given number in stock.
     */
    public void underGivenNumberInStock(int number)
    {
        for ( Product producto: stock)
        {
            if (producto.getQuantity() < number){
                System.out.println(producto);
            }
        }
    }
}
