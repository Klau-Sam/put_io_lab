package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import org.mockito.Mockito;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class ExpenseRepositoryTest {

    @Test
    public void testLoadExpenses() {
        /* ExpenseRepository mockObject = mock(ExpenseRepository.class);
        mockObject.loadExpenses();
        assertEquals(mockObject.getExpenses(), new ArrayList<>()); */

        IFancyDatabase fancy = mock(MyDatabase.class);
        ExpenseRepository expRep = new ExpenseRepository(fancy);
        expRep.loadExpenses();
        InOrder inOrder = inOrder(fancy);
        inOrder.verify(fancy).connect();
        inOrder.verify(fancy).queryAll();
        inOrder.verify(fancy).close();
        assertEquals(expRep.getExpenses(), new ArrayList<>());
    }

    @Test
    public void testExpenseRepository() {
        MyDatabase database = new MyDatabase();
        ExpenseRepository expRep = new ExpenseRepository(database);
        expRep.loadExpenses();
        assertEquals(expRep.getExpenses(), new ArrayList<>());
    }

    @Test
    public void testSaveExpenses() {
        IFancyDatabase fancy = mock(MyDatabase.class);
        ExpenseRepository expRep = new ExpenseRepository(fancy);
        Expense expense = new Expense();
        expRep.addExpense(expense);
        expRep.addExpense(new Expense());
        expRep.addExpense(new Expense());
        expRep.addExpense(new Expense());
        expRep.addExpense(new Expense());
        expRep.saveExpenses();
        verify(fancy, times(5)).persist(any(Expense.class));
    }


}
