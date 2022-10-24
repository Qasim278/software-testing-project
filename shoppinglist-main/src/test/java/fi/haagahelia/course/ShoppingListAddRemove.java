package fi.haagahelia.course;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ShoppingListAddRemove {
	
	@Test
	void testRemoveAddedItem() {
		
		database.ShoppingListItemDao dao = new database.FakeShoppingListItemDao();
		
		// check precondition
		List<model.ShoppingListItem> items = dao.getAllItems();
		boolean milkFound = false;
		boolean eggsFound = false;
		boolean breadFound = false;
		
		
		model.ShoppingListItem item = null;
		
		for(int i = 0; i < items.size(); i++) {
			
			String title = items.get(i).getTitle();
			if(title.equals("Milk")) {
				milkFound = true;
			} else if(title.equals("Eggs")) {
				eggsFound = true;
				item = items.get(i);
			}else if(title.equals("Bread")) {
				breadFound = true;
			}
			
		}
		
		assertTrue(milkFound && eggsFound && breadFound);
		
		
		// remove eggs
		
		dao.removeItem(item);
		
		// check if removal worked
		
		eggsFound = false;
		
		for(int i = 0; i < items.size(); i++) {
			
			String title = items.get(i).getTitle();
			if(title.equals("Eggs")) {
				eggsFound = true;
			}
			
			assertTrue(!eggsFound, "Eggs were not removed");
			
		}
	}
		
		@Test
		void testAddFirstItem() {
			
			database.ShoppingListItemDao dao = new database.FakeShoppingListItemDao();
			
			//make sure that the shoppingList is empty
			// shoppinglist items ids start from 1
			
			List<model.ShoppingListItem> items = dao.getAllItems();
			
			int size = items.size();
			
			for(int i = 1; i <= size; i++) {
				
				dao.removeItem(dao.getItem(i));
				
			}
			
			assertTrue(dao.getAllItems().size()== 0, "Shoppinglist is not empty");
			
			model.ShoppingListItem bread = new model.ShoppingListItem(1, "Bread");
			dao.addItem(bread);
			
			//search for the bread
			
			model.ShoppingListItem addedItem = null;
			
			items = dao.getAllItems();
			for(int i = 0; i < items.size(); i++) {
				
				if(items.get(i).getTitle().equals("Bread")) {
					
					addedItem = items.get(i);
				}
				
			}
			
			assertTrue(addedItem != null, "Bread was not found");
			assertTrue(addedItem.getId() == 1, "Id is not 1");
			assertTrue(addedItem.getTitle().equals("Bread"), "Title is not Bread");
			
		}
		
	}
	
	
