import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test {

    /* =========================
       DEPOSIT TESTS
       ========================= */

    // EP: Negative amount
    @Test
    void deposit_negativeAmount_shouldFail() {
        Account acc = new Account(100, "Verified");
        assertFalse(acc.deposit(-50));
        assertEquals(100, acc.getBalance());
    }

    // EP: Zero amount
    @Test
    void deposit_zeroAmount_shouldFail() {
        Account acc = new Account(100, "Verified");
        assertFalse(acc.deposit(0));
        assertEquals(100, acc.getBalance());
    }

    // EP: Closed account
    @Test
    void deposit_closedAccount_shouldFail() {
        Account acc = new Account(100, "Closed");
        assertFalse(acc.deposit(50));
        assertEquals(100, acc.getBalance());
    }

    // EP: Valid deposit
    @Test
    void deposit_validAmount_shouldSucceed() {
        Account acc = new Account(100, "Verified");
        assertTrue(acc.deposit(50));
        assertEquals(150, acc.getBalance());
    }

    /* =========================
       WITHDRAW TESTS
       ========================= */

    // State-based: Closed
    @Test
    void withdraw_closedAccount_shouldFail() {
        Account acc = new Account(100, "Closed");
        assertFalse(acc.withdraw(50));
        assertEquals(100, acc.getBalance());
    }

    // State-based: Suspended
    @Test
    void withdraw_suspendedAccount_shouldFail() {
        Account acc = new Account(100, "Suspended");
        assertFalse(acc.withdraw(50));
        assertEquals(100, acc.getBalance());
    }

    // BVA: Overdraft
    @Test
    void withdraw_amountGreaterThanBalance_shouldFail() {
        Account acc = new Account(100, "Verified");
        assertFalse(acc.withdraw(200));
        assertEquals(100, acc.getBalance());
    }

    // BVA: Exact balance
    @Test
    void withdraw_exactBalance_shouldSucceed() {
        Account acc = new Account(100, "Verified");
        assertTrue(acc.withdraw(100));
        assertEquals(0, acc.getBalance());
    }

    // EP: Valid withdrawal
    @Test
    void withdraw_validAmount_shouldSucceed() {
        Account acc = new Account(100, "Verified");
        assertTrue(acc.withdraw(40));
        assertEquals(60, acc.getBalance());
    }
}
