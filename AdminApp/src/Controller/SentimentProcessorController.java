package Controller;

import java.util.ArrayList;
import java.util.List;

import DBUtils.CommentContract;
import Model.Comment;
import Model.SentimentProcessor;
import helpers.Sentence;

public class SentimentProcessorController {
	
	Comment fetchObj ;

	public List<Comment> fetchComments() {
		// TODO Auto-generated method stub
		fetchObj = new Comment();
		return fetchObj.fetchAllUnprocessedComments();
		
	}
	public List<Comment> fetchComments(String productId){
		List<Comment> commentList= new ArrayList<Comment>();
		
		return commentList;
	}
	
	public String generateSentiment(String comment)
	{
		
		return SentimentProcessor.generateSentiment(comment);
		
	}
	
	
	public boolean updateCommentSentiment(Comment comment)
	{
		boolean status = false;
		
	 //  status = comment.updateComment(CommentContract.COMMENTSENTIMENT);
	   
	   return status;
	}
	
	
	
	

	

}
