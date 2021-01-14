package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.net.ConnectException;
import java.util.List;
import java.util.Random;

public class ExpenseManagerTest {

    @Test
    public void testCalculateTotal() {
        ExpenseRepository mockObjectRep = mock(ExpenseRepository.class);
        when(mockObjectRep.getExpenses()).thenReturn(List.of(
                new Expense(12),
                new Expense(13),
                new Expense(14)
        ));
        ExpenseManager expMan = new ExpenseManager(mockObjectRep, new FancyService());
        assertEquals(39, expMan.calculateTotal());
    }

    @Test
    public void testCalculateTotalForCategory() {
        ExpenseRepository mockObjectRep = mock(ExpenseRepository.class);

        when(mockObjectRep.getExpensesByCategory(any())).thenReturn(List.of());
        when(mockObjectRep.getExpensesByCategory("Home")).thenReturn(List.of(
                new Expense(12),
                new Expense(13),
                new Expense(14)
        ));
        when(mockObjectRep.getExpensesByCategory("Car")).thenReturn(List.of(
                new Expense(12),
                new Expense(13),
                new Expense(14)
        ));

        ExpenseManager expMan = new ExpenseManager(mockObjectRep, new FancyService());
        assertEquals(39, expMan.calculateTotalForCategory("Home"));
        assertEquals(39, expMan.calculateTotalForCategory("Car"));
        assertEquals(0, expMan.calculateTotalForCategory("Sport"));
        assertEquals(0, expMan.calculateTotalForCategory("Food"));
    }

    @Test
    public void testCalculateTotalInDollars() throws ConnectException {
        ExpenseRepository mockObjectRep = mock(ExpenseRepository.class);
        when(mockObjectRep.getExpenses()).thenReturn(List.of(
                new Expense(1)
        ));
        ExpenseManager expMan = new ExpenseManager(mockObjectRep, new FancyService());
        //assertEquals(0, expMan.calculateTotalInDollars());
        FancyService mockObjectFan = mock(FancyService.class);
        when(mockObjectFan.convert(anyDouble(), eq("PLN"),eq("USD"))).thenReturn(new FancyService().convert(anyDouble(), eq("PLN"), eq("USD")));
        assertEquals(4, expMan.calculateTotalInDollars());
    }
}
