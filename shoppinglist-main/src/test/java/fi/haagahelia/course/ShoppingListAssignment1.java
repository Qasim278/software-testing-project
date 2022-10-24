package fi.haagahelia.course;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import database.FakeShoppingListItemDao;

public class ShoppingListAssignment1 {

	@Test
	void testRemoveAddedItem() {

		database.FakeShoppingListItemDao dao = new database.FakeShoppingListItemDao();

		// check precondition
		List<model.ShoppingListItem> items = dao.getAllItems();
		boolean milkFound = false;
		boolean eggsFound = false;
		boolean breadFound = false;

		model.ShoppingListItem item = null;

		for (int i = 0; i < items.size(); i++) {

			String title = items.get(i).getTitle();
			if (title.equals("Milk")) {
				milkFound = true;
			} else if (title.equals("Eggs")) {
				eggsFound = true;
			} else if (title.equals("Bread")) {
				breadFound = true;
				item = items.get(i);
			}

		}

		assertTrue(breadFound);

		// remove bread

		dao.removeItem(item);

		// check if removal worked

		breadFound = false;

		for (int i = 0; i < items.size(); i++) {

			String title = items.get(i).getTitle();
			if (title.equals("Bread")) {
				breadFound = true;
			}

			assertTrue(!breadFound, "Bread was not removed");

		}
	}

	@Test
	void addItem() {

		database.FakeShoppingListItemDao dao = new database.FakeShoppingListItemDao();

		List<model.ShoppingListItem> items = dao.getAllItems();

		boolean flourFound = false;

		int size = items.size();

		for (int i = 1; i <= size; i++) {

			if (dao.getItem(i).equals("Flour")) {

				flourFound = true;

			}

			assertTrue(!flourFound);

		}

		model.ShoppingListItem flour = new model.ShoppingListItem(3, "Flour");
		dao.addItem(flour);

		items = dao.getAllItems();
		
		for (int i = 0; i < items.size(); i++) {

			String title = items.get(i).getTitle();
			if (items.size()== 4) {
				flourFound = true;
			}

			assertTrue(flourFound);

		}

	}
}
