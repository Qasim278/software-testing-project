package fi.haagahelia.course;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;



class ShoppingListSearch {

	@Test
	void testShoppingItemAdd() {

		database.ShoppingListItemDao dao = new database.FakeShoppingListItemDao();

		List<model.ShoppingListItem> items = dao.getAllItems();
		boolean breadFound = false;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals("Bread")) {
				breadFound = true;
			}
		}

		assertThat(breadFound);
	}

}
