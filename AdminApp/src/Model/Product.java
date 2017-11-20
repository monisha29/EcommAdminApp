package Model;
import java.util.*;

import org.json.JSONObject;

import DBUtils.DBFunctions;
import DBUtils.ProductContract;
public class Product {
	
  public String productId;
  public String productName;
  public String   productRating;
  public String productCommentSentiment;
  
  public Product(String productId , String productName, String productRating ,String producCommnetSentiment)
  {  this.productId=productId;
     this.productName=productName ;
     this.productRating=productRating;
     //this.productCommentSentiment=productCommentSentiment;
	  
  }
  public Product()
  {  super();
	  
  }
  
  public static List<Product> fetchAllProducts()
  {  List<Product> listOfProducts = new ArrayList<Product>();
     String productJson=DBFunctions.fetchAllDocuments(ProductContract.PRODUCTTABLENAME);
     listOfProducts = ProductContract.parseProductJson(productJson);
     
     return listOfProducts;
	  
  }
  public boolean updateProduct(String product)
  { try {
	   JSONObject json = ProductContract.generateJson(this);
	   
	   return DBFunctions.updateDocumentOnId(ProductContract.PRODUCTTABLENAME, this.productId,json);
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return false;
	  
  }
  
}
