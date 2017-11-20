package Controller;

import java.util.*;

import DBUtils.CommentContract;
import Model.Comment;
import Model.SentimentProcessor;
import Model.Product;
import Model.ProductRatingProcessor;

public class ProductRatingProcessorController {
	
	ProductRatingProcessor processor = new ProductRatingProcessor();
	
//	public List<Comment> fetchComments()
//	{
//		
//	}

	/*public List<String> fetchProductId() {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productIdS= new ArrayList<Product>();
		productIdS=product.fetchAllProducts();
		List<String> productId= new ArrayList<String>();
		Iterator itr= productIdS.iterator();
		while(itr.hasNext())
		{  
			Product p =(Product) itr.next();
			if(p.productIdequlas())
			
	}*/
	
	
	public String generateRating(String  productId)
	{
		
	   return processor.generateProductRating(productId);
		
	}
	
	
	public boolean updateProductRating(Product product)
	{
		boolean status = false;
		
	 //  status = comment.updateComment(CommentContract.COMMENTSENTIMENT);
	   
	   return status;
	}

	

}
