package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import DBUtils.ProductContract;
import DBUtils.DBFunctions;
import Model.Comment;

public class ProductRatingProcessor {

	public int  rating=0;
	public int  productRating;
	public String  generateProductRating(String productId)
	{   
		List<Comment> listOfComment = Comment.fetchAllUnprocessedComments(productId);
		for(int i=0;i<listOfComment.size();i++)
			
		{  
			String sentiment =listOfComment.get(i).sentiment;
			if(sentiment.equals("positive")){
			  rating+=5;
			 
			}
			else {
				rating+=1;
				
			}
			
		}
		productRating = rating/(listOfComment.size());
		System.out.print("1");
		
		return String.valueOf(productRating);
	}
	
	
	
}
