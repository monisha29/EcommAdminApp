package DBUtils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Comment;
import Model.Product;


public class ProductContract {
	public static String PRODUCTTABLENAME="product";
    //public static String PRODUCTID="productid";
    public static String PRODUCTNAME ="productname";
    //public static String PRODUCTOMMENTSENTIMENT ="productcommentsentiment";
    public static String PRODUCTRATING="productrating"; 	
    public static String PRODUCTID="productid";
    public static JSONObject generateJson(Product product) {
    	    JSONObject json = new JSONObject();
    	    try {
    	    	json.put(PRODUCTNAME, product.productName);
    	    	//json.put(PRODUCTOMMENTSENTIMENT, product.productCommentSentiment.toString());
    	    	json.put(PRODUCTRATING, product.productRating);
    	    	//json.put(PRODUCTID, product.productId);
    	    }
    	    catch(Exception e)
    	    {
    	    	e.printStackTrace();
    	    }
    	    	
    	   return json; 
    }
    public static List<Product> parseProductJson(String s)
    {
    	List<Product> productList = new ArrayList<Product>();
    	try {
    		 JSONArray productListJson = new JSONArray(s);
    		 for(int i=0;i<productListJson.length();i++) {
    			 JSONObject document = new JSONObject();
    		     Product product = new Product();
    		     document =  productListJson.getJSONObject(i);
    		     JSONObject id  = (JSONObject) document.get("_id");
	                product.productId = id.get("$oid").toString();
    		    // product.productId=document.get(PRODUCTID).toString();
    		     product.productRating=document.get(PRODUCTRATING).toString();
    		     //product.productCommentSentiment=document.get(PRODUCTOMMENTSENTIMENT).toString();
    		     product.productName=(String) document.get(PRODUCTNAME.toString());
    		     productList.add(product);
    		     
    		 }
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return productList; 
    }
    public static JSONObject JsonForUpdation(String field,String value)
    {
    	JSONObject json= new JSONObject();
    	try {
    		json.put(field,value);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return json;
    }
}
